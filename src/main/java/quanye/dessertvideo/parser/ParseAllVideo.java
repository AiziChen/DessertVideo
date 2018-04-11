package quanye.dessertvideo.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import quanye.dessertvideo.domain.Movies;
import quanye.dessertvideo.domain.Portrait;
import quanye.dessertvideo.domain.Sitcom;
import quanye.dessertvideo.domain.Video;
import quanye.dessertvideo.tools.Tools;

/**
 * 解析所有的电影，然后将它们保存到数据库中
 * 
 * @author QuanyeChen
 *
 */
public class ParseAllVideo {

	private static VideoNetCached parser;

	private ParseAllVideo() {
	}

	private static ParseAllVideo instance;

	public static ParseAllVideo getInstance() {
		if (instance == null) {
			instance = new ParseAllVideo();
		}
		if (parser == null) {
			parser = VideoNetCached.getInstance();
		}
		return instance;
	}

	/**
	 * 保存解析的数据到数据库
	 * 
	 * @param eles
	 * @param type
	 *            视频类型
	 * @throws IOException
	 */
	private void saveToDB(Elements eles, String type) throws IOException {
		for (int i = 0; i < eles.size(); ++i) {
			List<String> playLinks = new ArrayList<>();
			String name = eles.get(i).text();
			String link = eles.get(i).absUrl("href");
			Document detailDoc = Jsoup.connect(link).get();
			String imageLink = detailDoc.select("img.lazy").first().attr("src");
			String details = detailDoc.select("div.vodplayinfo").get(1).text();
			String releaseDate = detailDoc.select("div.vodinfobox").first().select("li").get(7).select("span").first()
					.text();
			Elements eles1 = detailDoc.select("li>input");
			for (Element ele1 : eles1) {
				String movieLinks = ele1.attr("value");
				if (!movieLinks.endsWith(".m3u8")) {
					playLinks.add(movieLinks);
				}
			}
			// 添加到数据库
			Video temp = Tools.getVideoDao().findByName(name);
			// 没有则直接保存
			if (temp == null) {
				Video video = new Video();
				video.setName(name);
				video.setPlayLinks(playLinks);
				video.setType(type);
				video.setImageLink(imageLink);
				video.setDetails(details);
				video.setReleaseDate(Tools.parseDate(releaseDate));
				Tools.getVideoDao().save(video);
			} else { // 有则更新
				temp.setPlayLinks(playLinks);
				temp.setType(type);
				temp.setImageLink(imageLink);
				temp.setDetails(details);
				temp.setReleaseDate(Tools.parseDate(releaseDate));
				Tools.getVideoDao().update(temp);
			}
		}
	}

	/**
	 * 解析
	 * 
	 * @throws IOException
	 */
	public void parse() throws IOException {
		// 解析电影
		for (Movies movie : Movies.values()) {
			Document doc = Jsoup.connect(movie.getLink()).get();
			String pageInfo = doc.selectFirst("div.pages").text();
			int page = Integer.parseInt(pageInfo.substring(pageInfo.indexOf('/') + 1, pageInfo.indexOf("页")));
			// 解析所有页
			for (int i = 0; i < page; ++i) {
				String link = movie.getLink();
				doc = Jsoup.connect(link.substring(0, link.lastIndexOf('-') + 1) + i + ".html").get();
				Elements eles = doc.select("span.xing_vb4>a");
				saveToDB(eles, movie.getName());
			}
		}
		// 解析连续剧
		for (Sitcom sitcom : Sitcom.values()) {
			Document doc = Jsoup.connect(sitcom.getLink()).get();
			String pageInfo = doc.selectFirst("div.pages").text();
			int page = Integer.parseInt(pageInfo.substring(pageInfo.indexOf('/') + 1, pageInfo.indexOf("页")));
			for (int i = 1; i <= page; ++i) {
				String link = sitcom.getLink();
				doc = Jsoup.connect(link.substring(0, link.lastIndexOf('-') + 1) + i + ".html").get();
				Elements eles = doc.select("span.xing_vb4>a");
				saveToDB(eles, sitcom.getName());
			}
		}
		// 解析写真视讯
		for (Portrait portrait : Portrait.values()) {
			Document doc = Jsoup.connect(portrait.getLink()).get();
			String pageInfo = doc.selectFirst("div.pages").text();
			int page = Integer.parseInt(pageInfo.substring(pageInfo.indexOf('/') + 1, pageInfo.indexOf("页")));
			for (int i = 0; i < page; ++i) {
				String link = portrait.getLink();
				doc = Jsoup.connect(link.substring(0, link.lastIndexOf('-') + 1) + i + ".html").get();
				Elements eles = doc.select("span.xing_vb4>a");
				saveToDB(eles, portrait.getName());
			}
		}
	}

}

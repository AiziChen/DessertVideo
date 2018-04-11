package quanye.dessertvideo.parser;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import quanye.dessertvideo.domain.Movies;
import quanye.dessertvideo.domain.Portrait;
import quanye.dessertvideo.domain.Sitcom;

/**
 * 联网并解析提取出相应的内容
 * 
 * @author QuanyeChen
 *
 */
public class VideoNetCached {
	private VideoNetCached() {
	}

	private static Document doc;
	private static VideoNetCached parser;

	/**
	 * 获取解析网的Document
	 * 
	 * @return
	 */
	private static Document getDocument() {
		if (doc == null) {
			try {
				doc = Jsoup.connect("http://www.33uudy.com").get();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return doc;
	}

	/**
	 * 缓存所有的视频列表
	 */
	private static void init() {
		// 缓存三个个视频列表
		cachedAllMovieElements();
		cachedAllPortraitElements();
		cachedAllSitComElements();
	}

	/**
	 * 单例方法
	 * 
	 * @return
	 */
	public static VideoNetCached getInstance() {
		if (parser == null) {
			parser = new VideoNetCached();
			init();
		}
		return parser;
	}

	/**
	 * 缓存所有的电影
	 * 
	 * @return
	 */
	private static Elements cachedAllMovieElements() {
		Elements eles = getDocument().select("div#m1>a");
		for (Element ele : eles) {
			String link = ele.absUrl("href");
			if (ele.text().equals(Movies.ACTION.getName())) {
				Movies.ACTION.setLink(link);
			} else if (ele.text().equals(Movies.COMEDY.getName())) {
				Movies.COMEDY.setLink(link);
			} else if (ele.text().equals(Movies.LOVE.getName())) {
				Movies.LOVE.setLink(link);
			} else if (ele.text().equals(Movies.SCIENCE.getName())) {
				Movies.SCIENCE.setLink(link);
			} else if (ele.text().equals(Movies.HORRO.getName())) {
				Movies.HORRO.setLink(link);
			} else if (ele.text().equals(Movies.PLOT.getName())) {
				Movies.PLOT.setLink(link);
			} else if (ele.text().equals(Movies.WAR.getName())) {
				Movies.WAR.setLink(link);
			} else if (ele.text().equals(Movies.ETHICS.getName())) {
				Movies.ETHICS.setLink(link);
			} else if (ele.text().equals(Movies.DISCIPLINE.getName())) {
				Movies.DISCIPLINE.setLink(link);
			}
		}
		return eles;
	}

	/**
	 * 缓存所有的连续剧
	 * 
	 * @return
	 */
	private static Elements cachedAllSitComElements() {
		Elements eles = getDocument().select("div#m2>a");
		for (Element ele : eles) {
			String link = ele.absUrl("href");
			if (ele.text().equals(Sitcom.CHINA.getName())) {
				Sitcom.CHINA.setLink(link);
			} else if (ele.text().equals(Sitcom.HONGKONG.getName())) {
				Sitcom.HONGKONG.setLink(link);
			} else if (ele.text().equals(Sitcom.KOREA.getName())) {
				Sitcom.KOREA.setLink(link);
			} else if (ele.text().equals(Sitcom.WESTERN.getName())) {
				Sitcom.WESTERN.setLink(link);
			} else if (ele.text().equals(Sitcom.JAPAN.getName())) {
				Sitcom.JAPAN.setLink(link);
			} else if (ele.text().equals(Sitcom.TAIWAN.getName())) {
				Sitcom.TAIWAN.setLink(link);
			} else if (ele.text().equals(Sitcom.TAIWAN.getName())) {
				Sitcom.TAIWAN.setLink(link);
			} else if (ele.text().equals(Sitcom.THAI.getName())) {
				Sitcom.THAI.setLink(link);
			} else if (ele.text().equals(Sitcom.VIETNAM.getName())) {
				Sitcom.VIETNAM.setLink(link);
			}
		}
		return eles;
	}

	/**
	 * 缓存所有的写真视频
	 * 
	 * @return
	 */
	private static Elements cachedAllPortraitElements() {
		Elements eles = getDocument().select("div#m5>a");
		for (Element ele : eles) {
			String link = ele.absUrl("href");
			if (ele.text().equals(Portrait.SHIXUN.getName())) {
				Portrait.SHIXUN.setLink(link);
			} else if (ele.text().equals(Portrait.TUIMO.getName())) {
				Portrait.TUIMO.setLink(link);
			}
		}
		return eles;
	}

	/**
	 * 获取综艺链接
	 * 
	 * @return
	 */
	public String getSynthesisLink() {
		return "http://www.33uudy.com" + "/?m=vod-type-id-3.html";
	}

	/**
	 * 获取动漫链接
	 * 
	 * @return
	 */
	public String getAnimationLink() {
		return "http://www.33uudy.com" + "/?m=vod-type-id-4.html";
	}

}

package quanye.dessertvideo.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import quanye.dessertvideo.domain.Video;
import quanye.dessertvideo.tools.Tools;

public class SearchAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int SUM = 20;
	private int page;
	private int totalPage;
	private String name;
	private List<Video> videos;

	@Override
	public String execute() throws Exception {
		videos = Tools.getVideoDao().findByNameLike(name);
		totalPage = videos.size() / SUM;
		if (page > totalPage) {
			return ERROR;
		} else if (totalPage == 0) {
			return SUCCESS;
		} else {
			if (page == 0) {
				page = 1;
			}
			videos = videos.subList((page - 1) * SUM, page * SUM);
		}
		return SUCCESS;
	}

	@Override
	public void validate() {
		if (name == null || name.isEmpty()) {

		}
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

}

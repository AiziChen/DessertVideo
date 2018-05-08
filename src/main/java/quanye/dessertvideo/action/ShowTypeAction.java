package quanye.dessertvideo.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import quanye.dessertvideo.domain.Video;
import quanye.dessertvideo.tools.Tools;

public class ShowTypeAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int SUM = 20;

	private String type;
	private int page;
	private int totalPage;
	private List<Video> videos;

	@Override
	public String execute() throws Exception {
		videos = Tools.getVideoDao().findByType(type);
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
		if (type == null || type.isEmpty()) {
		}
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

}

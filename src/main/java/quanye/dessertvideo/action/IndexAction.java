package quanye.dessertvideo.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import quanye.dessertvideo.domain.Movies;
import quanye.dessertvideo.domain.Video;
import quanye.dessertvideo.tools.Tools;

public class IndexAction extends ActionSupport {

	private List<Video> videos;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final int SUM = 20;
	private int page;
	private int totalPage;

	@Override
	public String execute() throws Exception {
		videos = Tools.getVideoDao().findAllVideo();
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

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

}

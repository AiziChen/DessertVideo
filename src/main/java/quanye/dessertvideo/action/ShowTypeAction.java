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

	private String type;
	private int page;
	private int totalPage;
	private List<Video> videos;

	@Override
	public String execute() throws Exception {
		if (type == null || type.isEmpty()) {
			return ERROR;
		}
		if (page == 0) {
			page = 1;
		}
		videos = Tools.getVideoDao().findByType(type).subList((page - 1) * 10, page * 10);
		totalPage = videos.size() / 10;
		return super.execute();
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

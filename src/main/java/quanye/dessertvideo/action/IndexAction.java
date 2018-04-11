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

	@Override
	public String execute() throws Exception {
		videos = Tools.getVideoDao().findByType(Movies.ACTION.getName());
		return SUCCESS;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}

}

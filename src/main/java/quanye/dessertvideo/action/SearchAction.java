package quanye.dessertvideo.action;

import com.opensymphony.xwork2.ActionSupport;

import quanye.dessertvideo.domain.Video;
import quanye.dessertvideo.tools.Tools;

public class SearchAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private Video[] videos;

	@Override
	public String execute() throws Exception {
		if (name == null || name.isEmpty()) {
			return ERROR;
		}
		videos = Tools.getVideoDao().findByNameLike(name);
		System.out.println(name);
		return super.execute();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Video[] getVideos() {
		return videos;
	}

	public void setVideos(Video[] videos) {
		this.videos = videos;
	}

}

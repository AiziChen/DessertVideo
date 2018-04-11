package quanye.dessertvideo.action;

import com.opensymphony.xwork2.ActionSupport;

import quanye.dessertvideo.domain.Video;
import quanye.dessertvideo.tools.Tools;

public class DetailsAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Video video;

	@Override
	public String execute() throws Exception {
		if (id == null) {
			return ERROR;
		}
		video = Tools.getVideoDao().get(id);
		return SUCCESS;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

}

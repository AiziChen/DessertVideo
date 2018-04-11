package quanye.dessertvideo.domain;

import java.util.Date;
import java.util.List;

/**
 * 电影POJO
 * 
 * @author QuanyeChen
 *
 */
public class Video {
	private int id;
	private String type;
	private String name;
	private List<String> playLinks;
	private String imageLink;
	private String details;
	private Date releaseDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getPlayLinks() {
		return playLinks;
	}

	public void setPlayLinks(List<String> playLinks) {
		this.playLinks = playLinks;
	}

	public String getImageLink() {
		return imageLink;
	}

	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

}

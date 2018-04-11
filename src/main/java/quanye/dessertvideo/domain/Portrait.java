package quanye.dessertvideo.domain;

/**
 * 写真视频分类的Enum
 * 
 * @author Administrator
 *
 */
public enum Portrait {
	TUIMO("腿模写真"), SHIXUN("视讯美女");

	private String name;
	private String link;

	private Portrait(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getName() {
		return name;
	}

}

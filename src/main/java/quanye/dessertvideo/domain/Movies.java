package quanye.dessertvideo.domain;

/**
 * 电影分类的Enum
 * @author Administrator
 *
 */
public enum Movies {
	ACTION("动作片"), COMEDY("喜剧片"), LOVE("爱情片"), SCIENCE("科幻片"), HORRO("恐怖片"), PLOT("剧情片"), WAR("战争片"), ETHICS(
			"伦理类"), DISCIPLINE("纪录片");

	private String name;
	private String link;

	private Movies(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}

package quanye.dessertvideo.domain;

/**
 * 连续剧分类的Enum
 * 
 * @author Administrator
 *
 */
public enum Sitcom {
	CHINA("国产剧"), HONGKONG("港剧"), KOREA("韩剧"), WESTERN("欧美剧"), JAPAN("日剧"), TAIWAN("台剧"), THAI("泰剧"), VIETNAM("越南剧");

	private String name;
	private String link;

	private Sitcom(String name) {
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

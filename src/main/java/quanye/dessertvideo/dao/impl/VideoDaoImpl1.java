package quanye.dessertvideo.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import quanye.dessertvideo.dao.VideoDao;
import quanye.dessertvideo.domain.Video;

public class VideoDaoImpl1 extends HibernateDaoSupport implements VideoDao {

	@Override
	public Video get(int id) {
		Video video = getHibernateTemplate().get(Video.class, id);
		return video;
	}

	@Override
	public void save(Video video) {
		getHibernateTemplate().save(video);
	}

	@Override
	public void update(Video video) {
		getHibernateTemplate().update(video);
	}

	@Override
	public void delete(int id) {
		getHibernateTemplate().delete(get(id));
	}

	@Override
	public void delete(Video video) {
		getHibernateTemplate().delete(video);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Video> findByType(String type) {
		List<?> list = getHibernateTemplate().find("from Video v where v.type = ?", type);
		return (List<Video>) list;
	}

	@Override
	public List<Video> findAllVideo() {
		return getHibernateTemplate().findByExample(new Video());
	}

	@Override
	public int getVideoCount() {
		int num = (int) getHibernateTemplate().iterate("select count(*) from Video as p").next();
		return num;
	}

	@Override
	public Video findByName(String name) {
		// Hibernate的findByExample方法若查找不到内容，则会返回一个空List，而不是null
		Video video = new Video();
		video.setName(name);
		List<Video> list = getHibernateTemplate().findByExample(video);
		if (list.isEmpty()) {
			return null;
		} else {
			return list.get(0);
		}
	}

	/**
	 * 模糊查找
	 * 
	 * @param name
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Video> findByNameLike(String name) {
		List<?> list = getHibernateTemplate().find("from Video as v where v.name like ?", "%" + name + "%");
		return (List<Video>)list;
	}

}

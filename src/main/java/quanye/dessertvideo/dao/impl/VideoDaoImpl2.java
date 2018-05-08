package quanye.dessertvideo.dao.impl;

import java.util.List;
import org.hibernate.SessionFactory;

import quanye.dessertvideo.dao.VideoDao;
import quanye.dessertvideo.domain.Video;

public class VideoDaoImpl2 implements VideoDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Video get(int id) {
		return (Video) sessionFactory.getCurrentSession().get(Video.class, id);
	}

	@Override
	public void save(Video video) {
		sessionFactory.getCurrentSession().save(video);
	}

	@Override
	public void update(Video video) {
		sessionFactory.getCurrentSession().update(video);
	}

	@Override
	public void delete(int id) {
		sessionFactory.getCurrentSession().delete(get(id));
	}

	@Override
	public void delete(Video video) {
		sessionFactory.getCurrentSession().delete(video);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Video> findByType(String type) {
		List<?> result = sessionFactory.getCurrentSession().createQuery("from Video as v where v.type = :type")
				.setString("type", "%"+type+"%").list();
		return (List<Video>) result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Video> findAllVideo() {
		List<?> result = sessionFactory.getCurrentSession().createQuery("from Video").list();
		return (List<Video>) result;
	}

	@Override
	public int getVideoCount() {
		List<?> list = sessionFactory.getCurrentSession().createQuery("select count(*) from Video as p").list();
		// 返回查询得到的实体总数
		if (list != null && list.size() == 1) {
			return (int) list.get(0);
		}
		return 0;
	}

	@Override
	public Video findByName(String name) {
		List<?> result = sessionFactory.getCurrentSession().createQuery("from Video as v where v.name = :name")
				.setString("name", name).list();
		return (Video) result.get(0);
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
		List<?> list = sessionFactory.getCurrentSession().createQuery("from Video v where v.name like :name")
				.setString("name", "%"+name+"%").list();
		return (List<Video>)list;
	}

}

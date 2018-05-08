package quanye.dessertvideo.dao;

import java.util.List;

import quanye.dessertvideo.common.BaseDao;
import quanye.dessertvideo.domain.Video;

public interface VideoDao extends BaseDao<Video> {

	Video get(int id);

	void save(Video video);

	void update(Video video);

	void delete(int id);

	void delete(Video video);

	List<Video> findByType(String type);

	List<Video> findAllVideo();

	int getVideoCount();

	Video findByName(String name);

	List<Video> findByNameLike(String name);
}

package quanye.dessertvideo.common;

public interface BaseDao<T> {

	T get(int id);

	void save(T t);

	void update(T t);

	void delete(int id);

	void delete(T t);
}

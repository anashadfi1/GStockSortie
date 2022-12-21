package dao;

import java.util.List;

public interface iDao<T> {

	boolean create(T o);

	boolean delete(T o);

	boolean update(T o);

	T findById(int id);

	List<T> findAll();
}


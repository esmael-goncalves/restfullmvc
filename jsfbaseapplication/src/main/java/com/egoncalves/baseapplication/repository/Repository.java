package com.egoncalves.baseapplication.repository;

import java.util.List;

public interface Repository<T> {
	void save(T entity);
	
	void save(List<T> entities);

	void delete(T entity);

	void update(T entity);

	T findById(long entityId);

	List<T> findAll();
}

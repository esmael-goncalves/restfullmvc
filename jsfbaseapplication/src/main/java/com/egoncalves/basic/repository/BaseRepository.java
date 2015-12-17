package com.egoncalves.basic.repository;

import java.util.List;

import javax.persistence.EntityManager;

public abstract class BaseRepository<T> implements Repository<T> {

	private EntityManager entityManager;

	@Override
	public void save(T entity) {
		this.entityManager.persist(entity);

	}

	@Override
	public void save(List<T> entities) {
		if (!entities.isEmpty()) {
			for (T t : entities) {
				this.entityManager.persist(t);
			}
		}

	}

	@Override
	public void delete(T entity) {
		this.entityManager.remove(entity);

	}

	@Override
	public void update(T entity) {
		this.entityManager.merge(entity);

	}

	@Override
	public T findById(long entityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

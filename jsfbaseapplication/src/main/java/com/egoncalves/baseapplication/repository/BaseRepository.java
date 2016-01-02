package com.egoncalves.baseapplication.repository;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.egoncalves.baseapplication.model.BaseEntity;

/**
 * Base implementation of the interface {@link #Repository}
 * @author Esmael
 *
 * @param <P> Type of Primary Key of the Entity's Repository
 * @param <T> Type of the Entity's Repository
 */
public abstract class BaseRepository<P, T extends BaseEntity> implements Repository<P, T> {

	@Inject
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
	public T findById(P entityId) {
		return (T) entityManager.find(getTypeClass(),entityId); 
	}

	@Override
	public List<T> findAll() {
		return entityManager.createQuery(("FROM " + getTypeClass().getName()))
                .getResultList();
	}
	
	private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
        return clazz;
    }

}

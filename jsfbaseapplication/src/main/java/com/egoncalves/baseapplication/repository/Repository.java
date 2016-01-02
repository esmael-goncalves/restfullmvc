package com.egoncalves.baseapplication.repository;

import java.util.List;

import com.egoncalves.baseapplication.model.BaseEntity;

/**
 * Interface that represents the Repository Pattern. 
 * It contains the basic methods to perform operations like save, update,
 * delete and search items in the database.
 * 
 * @author Esmael
 *
 * @param <PK> Type of Primary Key of the Entity's Repository
 * @param <T> Type of the Entity's Repository
 */
public interface Repository<PK, T extends BaseEntity> {
	void save(T entity);
	
	void save(List<T> entities);

	void delete(T entity);

	void update(T entity);

	T findById(PK entityId);

	List<T> findAll();
}

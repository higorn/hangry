package com.mycompany.webapi.persistence.dao.jpa;

import com.mycompany.webapi.model.entity.Modelable;
import com.mycompany.webapi.persistence.dao.Dao;

import javax.persistence.EntityManager;

public abstract class AbstractDaoJpa<M extends Modelable> implements Dao<M> {

	private EntityManager entityManager;

	public AbstractDaoJpa(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

  protected abstract Class<M> getEntityClass();

  @Override
	public M findById(final Integer id) {
	  return entityManager.find(getEntityClass(), id);
  }

  @Override
  public M update(M model) {
    return entityManager.merge(model);
  }
}

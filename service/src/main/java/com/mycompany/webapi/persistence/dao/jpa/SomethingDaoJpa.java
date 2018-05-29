package com.mycompany.webapi.persistence.dao.jpa;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.mycompany.webapi.model.entity.Something;
import com.mycompany.webapi.persistence.config.DataSourceQualifier;
import com.mycompany.webapi.persistence.dao.SomethingDao;

public class SomethingDaoJpa extends AbstractDaoJpa implements SomethingDao {

	@Inject
	public SomethingDaoJpa(@DataSourceQualifier final EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Something> getAll(final String filter) {
		Calendar now = Calendar.getInstance();
		String sql = "SELECT s FROM Something s"
				+ " WHERE"
					+ " lower(s.name) like lower(:name)"
				+ " ORDER BY s.name";

		String _filter = filter == null ? "" : filter;
		final TypedQuery<Something> query = getEntityManager().createQuery(sql, Something.class);
		query.setParameter("name", "%" + _filter + "%");
		return query.getResultList();
	}

}

package com.mycompany.webapi.persistence.dao.jpa;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.mycompany.webapi.JpaBasedDBTestCase;
import com.mycompany.webapi.WeldJUnit4Runner;
import org.dbunit.IDatabaseTester;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.mycompany.webapi.model.entity.Something;
import com.mycompany.webapi.persistence.dao.SomethingDao;

@RunWith(WeldJUnit4Runner.class)
public class SomethingDaoJpaIT extends JpaBasedDBTestCase {

	@Inject
	private SomethingDao dao;

	@Override
	protected String getDataSetPath() {
		return "/dataset/Something.xml";
	}
	
	@Override
	protected EntityManager getEntityManager() {
		return ((AbstractDaoJpa)dao).getEntityManager();
	}

	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	@Test
	public void itShouldGetAllSomethings() {
		List<Something> somethings = dao.getAll("");
		Assert.assertNotNull(somethings);
		Assert.assertFalse(somethings.isEmpty());
		Assert.assertEquals(3, somethings.size());
	}

	@Test
	public void forNullFilterItShouldGetAllSomethings() {
		List<Something> somethings = dao.getAll(null);
		Assert.assertNotNull(somethings);
		Assert.assertFalse(somethings.isEmpty());
		Assert.assertEquals(3, somethings.size());
	}

	@Test
	public void itShouldGetAllSomethingsByName() {
		List<Something> somethings = dao.getAll("anything1");
		Assert.assertNotNull(somethings);
		Assert.assertFalse(somethings.isEmpty());
		Assert.assertEquals(1, somethings.size());
	}

}

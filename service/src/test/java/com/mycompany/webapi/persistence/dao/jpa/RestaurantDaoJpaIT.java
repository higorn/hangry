package com.mycompany.webapi.persistence.dao.jpa;

import com.mycompany.webapi.JpaBasedDBTestCase;
import com.mycompany.webapi.WeldJUnit4Runner;
import com.mycompany.webapi.model.entity.Restaurant;
import com.mycompany.webapi.persistence.dao.RestaurantDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@RunWith(WeldJUnit4Runner.class)
public class RestaurantDaoJpaIT extends JpaBasedDBTestCase {

	@Inject
	private RestaurantDao dao;

	@Override
	protected String getDataSetPath() {
		return "/dataset/db.xml";
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
	public void itShouldGetAListOfRestaurants() {
		List<Restaurant> restaurants = dao.getList("");
		Assert.assertNotNull(restaurants);
		Assert.assertFalse(restaurants.isEmpty());
		Assert.assertEquals(3, restaurants.size());
	}

	@Test
	public void forNullFilterItShouldGetAllRestaurants() {
		List<Restaurant> restaurants = dao.getList(null);
		Assert.assertNotNull(restaurants);
		Assert.assertFalse(restaurants.isEmpty());
		Assert.assertEquals(3, restaurants.size());
	}

	@Test
	public void itShouldGetAllRestaurantsByName() {
		List<Restaurant> restaurants = dao.getList("Moreira");
		Assert.assertNotNull(restaurants);
		Assert.assertFalse(restaurants.isEmpty());
		Assert.assertEquals(1, restaurants.size());
	}

	@Test
	public void itShouldGetRestaurantById() {
	  Restaurant restaurant = dao.findById(1);
	  Assert.assertNotNull(restaurant);
	  Assert.assertEquals("Xis da Gringa", restaurant.getName());
  }

  @Test
  public void itShouldUpdateRestaurant() {
    Restaurant restaurant = dao.findById(1);

    Assert.assertNotNull(restaurant);
    Assert.assertEquals("Xis da Gringa", restaurant.getName());
    Assert.assertEquals(Integer.valueOf(0), restaurant.getLikes());

    restaurant.setLikes(1);
    Restaurant restaurantUpdated = dao.update(restaurant);

    restaurant = dao.findById(1);
    Assert.assertEquals(restaurantUpdated.getLikes(), restaurant.getLikes());
  }
}

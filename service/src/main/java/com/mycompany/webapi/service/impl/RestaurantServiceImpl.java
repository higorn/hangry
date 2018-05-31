package com.mycompany.webapi.service.impl;

import com.mycompany.webapi.model.dto.RestaurantDTO;
import com.mycompany.webapi.model.entity.Restaurant;
import com.mycompany.webapi.persistence.dao.RestaurantDao;
import com.mycompany.webapi.service.RestaurantService;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class RestaurantServiceImpl implements RestaurantService {
	@Inject
	private RestaurantDao dao;

	public List<RestaurantDTO> getList(final String filter) {
		List<Restaurant> restaurantList = dao.getList(filter);
		return restaurantList.stream()
			.map(restaurant -> new RestaurantDTO(restaurant.getId(), restaurant.getName(), restaurant.getLikes()))
			.collect(Collectors.toList());
	}

  @Override
  public RestaurantDTO update(Integer id, RestaurantDTO restaurant) {
    return restaurant;
  }

  @Override
  public Integer like(Integer id) {
    Restaurant restaurant = dao.findById(id);
    restaurant.setLikes(restaurant.getLikes() == null ? 1 : restaurant.getLikes()+1);
    dao.update(restaurant);
    return restaurant.getLikes();
  }
}

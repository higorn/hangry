package com.mycompany.webapi.persistence.dao;

import com.mycompany.webapi.model.entity.Restaurant;

import java.util.List;

public interface RestaurantDao extends Dao<Restaurant> {

	List<Restaurant> getList(String filter);
}

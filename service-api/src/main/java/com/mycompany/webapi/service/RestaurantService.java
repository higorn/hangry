package com.mycompany.webapi.service;

import com.mycompany.webapi.model.dto.RestaurantDTO;

import java.util.List;


public interface RestaurantService {
	List<RestaurantDTO> getList(String filter);
  RestaurantDTO update(Integer id, RestaurantDTO restaurant);
  Integer like(Integer id);
}

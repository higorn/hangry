package com.mycompany.webapi.persistence.dao;

import java.util.List;

import com.mycompany.webapi.model.entity.Something;

public interface SomethingDao {

	List<Something> getAll(String filter); 
}

package com.mycompany.webapi.persistence.dao;/*
 * File:   Dao.java
 *
 * Created on 31/05/18, 15:56
 */

import com.mycompany.webapi.model.entity.Modelable;

import java.util.List;

public interface Dao<M extends Modelable> {
  List<M> findAll(String filter);
  M findById(Integer id);
  M update(M model);
}

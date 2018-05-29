/*
 * File:   Something.java
 *
 * Created on 28/05/18, 21:51
 */
package com.mycompany.webapi.model;

/**
 * @author higor
 */
public class Something {
  private Integer id;
  private String name;

  public Something() {
  }

  public Something(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

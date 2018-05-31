package com.mycompany.webapi.model.dto;

public class RestaurantDTO {

	private Integer id;
	private String name;
	private Integer likes;

	public RestaurantDTO() {
	}

	public RestaurantDTO(final Integer id, final String nome) {
		this.id = id;
		this.name = nome;
	}

  public RestaurantDTO(Integer id, String name, Integer likes) {
    this.id = id;
    this.name = name;
    this.likes = likes;
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
  public Integer getLikes() {
    return likes;
  }
  public void setLikes(Integer likes) {
    this.likes = likes;
  }
}

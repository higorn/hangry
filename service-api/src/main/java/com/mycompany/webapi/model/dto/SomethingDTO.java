package com.mycompany.webapi.model.dto;

public class SomethingDTO {

	private Integer id;
	private String name;

	public SomethingDTO() {
	}

	public SomethingDTO(final Integer id, final String nome) {
		this.id = id;
		this.name = nome;
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

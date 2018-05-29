package com.mycompany.webapi.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "Something")
@Table(name = "something")
@SequenceGenerator(name = "sequenceSomething", sequenceName = "seq_something")
public class Something {

	@Id
	@GeneratedValue(generator = "sequenceSomething")
	private Integer id;

	private String name;

	public Something() {
		super();
	}

	public Something(final Integer codigo, final String name) {
		this.id = codigo;
		this.name = name;
	}
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		}
		if (!(object instanceof Something)) {
			return false;
		}
		Something other = (Something) object;
		if (this.id == null || other.id == null) {
			return false;
		}
		return this.id.equals(other.id);
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		int result = 37 * 17;
		if (this.id != null) {
			result = (37 * this.id + result);
		}
		return result;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "Id Something: " + this.id;
	}
}

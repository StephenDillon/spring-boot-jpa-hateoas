package com.yodes.movies.api.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Movie extends AbstractModel {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

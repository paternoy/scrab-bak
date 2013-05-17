package com.coopnex.odm.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.coopnex.scrab.data.entity.AbstractEntity;

@Entity
@Table
public class Unit extends AbstractEntity<Integer>{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	Integer id;

	@Column
	String name;

	@Column
	String type;

	@Column
	String abbreviation;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
}

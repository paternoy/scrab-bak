package com.coopnex.odm.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.coopnex.scrab.data.entity.AbstractEntity;

@Entity
@Table
public class Variable extends AbstractEntity<Long> {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@Column
	private String name;

	@Column
	private String code;
	
	@ManyToOne
	@JoinColumn(name = "unitId")
	Unit unit;

	public Variable() {
		super();
	}

	public Variable(Long id, String name, String code) {
		super();
		this.name = name;
		this.code = code;
	}

	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Variable [id=" + id + ", name=" + name + ", code=" + code
				+ ", unit=" + unit + "]";
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}
}

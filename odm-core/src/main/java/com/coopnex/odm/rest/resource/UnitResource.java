package com.coopnex.odm.rest.resource;

import com.coopnex.odm.data.entity.Unit;
import com.coopnex.scrab.rest.resource.AbstractResource;

public class UnitResource extends AbstractResource<Unit> {
	private String name;
	private String abbreviation;
	private String type;

	public UnitResource() {
		super();
	}

	public UnitResource(Unit entity) {
		super();
		name = entity.getName();
		abbreviation = entity.getAbbreviation();
		type = entity.getType();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

}
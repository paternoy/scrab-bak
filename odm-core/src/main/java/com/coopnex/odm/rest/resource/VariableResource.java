package com.coopnex.odm.rest.resource;

import com.coopnex.odm.data.entity.Variable;
import com.coopnex.scrab.rest.resource.AbstractResource;



public class VariableResource extends AbstractResource<Variable> {
	private String name;
	private String code;
	
	public VariableResource(Variable entity) {
		super();
		code=entity.getCode();
		name=entity.getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
}

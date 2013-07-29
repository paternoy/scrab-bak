package com.coopnex.odm.rest.resource.assembler;

import org.springframework.stereotype.Component;

import com.coopnex.odm.data.entity.DataValue;
import com.coopnex.odm.rest.controller.DataValueRestController;
import com.coopnex.odm.rest.resource.DataValueResource;
import com.coopnex.scrab.rest.resource.AbstractResourceAssembler;

@Component
public class DataValueResourceAssembler extends
		AbstractResourceAssembler<DataValue, DataValueResource> {

	public DataValueResourceAssembler() {
		super(DataValueRestController.class, DataValue.class);
	}

	@Override
	public DataValueResource toResource(DataValue entity) {
//		 super.toResource(entity);
		 DataValueResource resource =this.instantiateResource(entity);
//		if (entity.getVariable() != null) {
//			resource.add(linkTo(VariableRestController.class).slash(
//					entity.getVariable().getId()).withRel("variable"));
//		}
		return resource;
	}

	@Override
	protected DataValueResource instantiateResource(DataValue entity) {
		return new DataValueResource(entity);
	}
}

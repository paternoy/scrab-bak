package com.coopnex.odm.rest.resource.assembler;

import org.springframework.stereotype.Component;

import com.coopnex.odm.data.entity.Unit;
import com.coopnex.odm.rest.controller.UnitRestController;
import com.coopnex.odm.rest.resource.UnitResource;
import com.coopnex.scrab.rest.resource.AbstractResourceAssembler;

@Component
public class UnitResourceAssembler extends AbstractResourceAssembler<Unit, UnitResource>{

	public UnitResourceAssembler() {
		super(UnitRestController.class, Unit.class);
	}
	
	@Override
	protected UnitResource instantiateResource(Unit entity) {
		return new UnitResource(entity);
	}
}

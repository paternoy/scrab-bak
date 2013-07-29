package com.coopnex.odm.rest.resource.assembler;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.stereotype.Component;

import com.coopnex.odm.data.entity.Variable;
import com.coopnex.odm.rest.controller.UnitRestController;
import com.coopnex.odm.rest.controller.VariableRestController;
import com.coopnex.odm.rest.resource.VariableResource;
import com.coopnex.scrab.rest.resource.AbstractResourceAssembler;

@Component
public class VariableResourceAssembler extends AbstractResourceAssembler<Variable, VariableResource>{

	public VariableResourceAssembler() {
		super(VariableRestController.class, Variable.class);
	}
	@Override
	public VariableResource toResource(Variable entity) {
		VariableResource resource = super.toResource(entity);
		 if (entity.getUnit()!=null) {
			 resource.add(linkTo(UnitRestController.class).slash(entity.getUnit().getId()).withRel("units"));
		}
		return resource;
	}
	
	@Override
	protected VariableResource instantiateResource(Variable entity) {
		return new VariableResource(entity);
	}
}

package com.coopnex.odm.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coopnex.odm.data.entity.Variable;
import com.coopnex.odm.rest.resource.VariableResource;
import com.coopnex.odm.rest.resource.assembler.VariableResourceAssembler;
import com.coopnex.odm.service.VariableService;
import com.coopnex.scrab.rest.controller.RestController;
import com.coopnex.scrab.rest.resource.AbstractResourceAssembler;

@Controller
@ExposesResourceFor(VariableResource.class)
@RequestMapping("/variables")
public class VariableRestController extends
		RestController<Variable, Long, VariableResource> {
	@Autowired
	VariableService variableService;
	
	@Autowired
	VariableResourceAssembler variableResourceAssembler;

	@RequestMapping(value = "", params = { "code" }, method = RequestMethod.GET)
	public @ResponseBody
	VariableResource getVariableByCode(
			@RequestParam(value = "code", required = true) String code) {
		return getResourceAssembler().toResource(getService().getVariableByCode(code));

	}

	protected VariableService getService() {
		
		return variableService;
	}

	protected AbstractResourceAssembler<Variable, VariableResource> getResourceAssembler() {
		return variableResourceAssembler;
	}

}

package com.coopnex.odm.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coopnex.odm.data.entity.Variable;
import com.coopnex.odm.service.VariableService;
import com.coopnex.scrab.rest.controller.CrudController;

@Controller
@RequestMapping("/variables*")
public class VariableController extends CrudController<Variable, Long> {
	
	@Autowired
	VariableService variableService;
	
	@RequestMapping(value = "", params = { "code" }, method = RequestMethod.GET)
	public @ResponseBody
	Variable getVariableByCode(
			@RequestParam(value = "code", required = true) String code) {
		return getService().getVariableByCode(code);

	}

	@Override
	protected VariableService getService() {
		return variableService;
	}

}
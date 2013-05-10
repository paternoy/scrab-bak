package com.coopnex.scrab.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coopnex.scrab.data.entity.Variable;
import com.coopnex.scrab.service.VariableService;

@Controller
public class VariableController {
	static Random r = new Random();

	@Autowired
	VariableService variableService;

	@RequestMapping(value = "/variables/{code}", method = RequestMethod.GET)
	public @ResponseBody
	Variable getVariable(@PathVariable String code) {
		return variableService.getVariableByCode(code);

	}

	@RequestMapping(value = "/variables", method = RequestMethod.GET)
	public @ResponseBody
	List<Variable> getVariables() {
		List<Variable> result = new ArrayList<Variable>();
		List<Variable> variables = variableService.getVariables();
		for (Variable variable : variables) {
			result.add(new Variable(variable.getId(), variable.getCode(),
					variable.getName()));
		}
		return result;

	}

	@RequestMapping(value = "/variables/create", method = RequestMethod.PUT)
	public @ResponseBody
	Variable getVariables(@RequestBody Variable variable) {
		return variableService.createVariable(variable);
	}


}
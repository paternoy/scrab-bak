package com.coopnex.restest.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coopnex.restest.dao.VariableDao;
import com.coopnex.restest.entity.Variable;
import com.coopnex.restest.model.DataSeries;
import com.coopnex.restest.service.VariableService;

@Controller
public class VariableController {
	static Random r = new Random();

	@Autowired
	VariableDao variableDao;

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

	@RequestMapping(value = "/series/{code}", method = RequestMethod.GET)
	public @ResponseBody
	DataSeries getSeries(
			@PathVariable String code,
			@RequestParam(value = "num", required = false, defaultValue = "10") int num) {
		DataSeries dataSeries = new DataSeries();
		dataSeries.setBeginDate(new Date());
		Calendar calendar = Calendar.getInstance();
		dataSeries.setEndDate(calendar.getTime());
		calendar.add(Calendar.DAY_OF_YEAR, num);
		dataSeries.setEndDate(calendar.getTime());
		float[] dataValues = new float[num];
		for (int i = 0; i < dataValues.length; i++) {
			dataValues[i] = r.nextFloat();
		}
		dataSeries.setDataValues(dataValues);
		return dataSeries;

	}

}

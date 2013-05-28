package com.coopnex.odm.ui.controller;

import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coopnex.odm.data.entity.DataValue;
import com.coopnex.odm.service.DataValueService;
import com.coopnex.odm.service.dto.SeriesDto;
import com.coopnex.scrab.rest.controller.CrudController;

@Controller
@RequestMapping("/datavalues*")
public class DataValueController extends CrudController<DataValue, Long> {
	private static Logger log = LoggerFactory
			.getLogger(DataValueController.class);

	@Autowired
	private DataValueService service;

	Random r = new Random(System.currentTimeMillis());

	@Override
	protected DataValueService getService() {
		return service;
	}

	@RequestMapping(value = "series", method = RequestMethod.GET)
	public @ResponseBody
	SeriesDto getVariableByCode(
			@RequestParam(value = "variableCode", required = true) String variableCode,
			@RequestParam(value = "beginDateTime", required = false) Date beginDateTime,
			@RequestParam(value = "endDateTime", required = false) Date endDateTime) {

		return getService().getSeries(variableCode, beginDateTime, endDateTime);

	}

	@RequestMapping(value = "generate", method = RequestMethod.GET)
	public @ResponseBody
	DataValue generate(
			@RequestParam(value = "variableCode", required = true) String variableCode) {
		DataValue dataValue = getService().create(variableCode, new Date(),
				(float) (20 - 5 * r.nextGaussian()));
		log.info("Generated " + dataValue);
		return dataValue;

	}

}
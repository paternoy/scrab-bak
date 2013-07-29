package com.coopnex.odm.rest.controller;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coopnex.odm.data.entity.DataValue;
import com.coopnex.odm.rest.resource.DataValueResource;
import com.coopnex.odm.rest.resource.assembler.DataValueResourceAssembler;
import com.coopnex.odm.service.DataValueService;
import com.coopnex.odm.service.dto.SeriesDto;
import com.coopnex.scrab.rest.controller.RestController;
import com.coopnex.scrab.rest.resource.AbstractResourceAssembler;

@Controller
@RequestMapping("/datavalues")
public class DataValueRestController extends RestController<DataValue, Long,DataValueResource> {
	private static Logger log = LoggerFactory
			.getLogger(DataValueRestController.class);

	@Autowired
	private DataValueService service;
	@Autowired
	private DataValueResourceAssembler assembler;

	Random r = new Random(System.currentTimeMillis());

	@Override
	protected DataValueService getService() {
		return service;
	}

	@RequestMapping(value = "series", method = RequestMethod.GET)
	public @ResponseBody
	List<DataValueResource> getSeries(
			@RequestParam(value = "variableCode", required = true) String variableCode,
			@RequestParam(value = "beginDateTime", required = false) @DateTimeFormat(iso=ISO.DATE) Date beginDateTime,
			@RequestParam(value = "endDateTime", required = false) @DateTimeFormat(iso=ISO.DATE) Date endDateTime) {
		SeriesDto series = getService().getSeries(variableCode, beginDateTime, endDateTime);
		
		return getResourceAssembler().toResources(series.getValues());

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

	@Override
	protected DataValueResourceAssembler getResourceAssembler() {
		return assembler;
	}

}
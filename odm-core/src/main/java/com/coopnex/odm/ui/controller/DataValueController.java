package com.coopnex.odm.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coopnex.odm.data.entity.DataValue;
import com.coopnex.odm.service.DataValueService;
import com.coopnex.scrab.rest.controller.CrudController;

@Controller
@RequestMapping("/datavalues*")
public class DataValueController extends CrudController<DataValue, Long> {

	@Autowired
	private DataValueService service;

	@Override
	protected DataValueService getService() {
		return service;
	}

}
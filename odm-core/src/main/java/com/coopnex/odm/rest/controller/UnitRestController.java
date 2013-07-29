package com.coopnex.odm.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coopnex.odm.data.entity.Unit;
import com.coopnex.odm.rest.resource.UnitResource;
import com.coopnex.odm.rest.resource.assembler.UnitResourceAssembler;
import com.coopnex.odm.service.UnitService;
import com.coopnex.scrab.rest.controller.RestController;
import com.coopnex.scrab.rest.resource.AbstractResourceAssembler;

	@Controller
	@RequestMapping("/units/")
	public class UnitRestController extends RestController<Unit, Integer,UnitResource> {
		
		@Autowired
		UnitService service;
		
		@Autowired
		UnitResourceAssembler resourceAssembler;
		

		@Override
		public UnitService getService() {
			return service;
		}


		@Override
		protected AbstractResourceAssembler<Unit, UnitResource> getResourceAssembler() {
			return resourceAssembler;
		}

	}

package com.coopnex.odm.ui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.coopnex.odm.data.entity.Unit;
import com.coopnex.odm.data.repository.UnitRepository;
import com.coopnex.scrab.rest.controller.CrudRepositoryRestController;
//
//@Controller
//@RequestMapping("/units*")
public class UnitController extends CrudRepositoryRestController<Unit, Integer> {
	
	@Autowired
	UnitRepository repository;
	

	@Override
	public UnitRepository getRepository() {
		return repository;
	}

}
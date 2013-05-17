package com.coopnex.odm.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coopnex.odm.data.entity.Unit;
import com.coopnex.odm.data.repository.UnitRepository;
import com.coopnex.scrab.service.CrudService;

@Service
public class UnitService extends CrudService<Unit, Integer>{

	@Autowired
	UnitRepository repository;

	@Override
	protected UnitRepository getRepository() {
		return repository;
	}
}
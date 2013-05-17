package com.coopnex.odm.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coopnex.odm.data.entity.DataValue;
import com.coopnex.odm.data.repository.DataValueRepository;
import com.coopnex.scrab.service.CrudService;

@Service
public class DataValueService extends CrudService<DataValue, Long>{

	@Autowired
	DataValueRepository repository;

	@Override
	protected DataValueRepository getRepository() {
		return repository;
	}
}
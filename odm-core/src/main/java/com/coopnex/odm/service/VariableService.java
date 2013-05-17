package com.coopnex.odm.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coopnex.odm.data.entity.Variable;
import com.coopnex.odm.data.repository.VariableRepository;
import com.coopnex.scrab.service.CrudService;

@Service
public class VariableService extends CrudService<Variable, Long>{

	@Autowired
	VariableRepository repository;
	
	@Transactional
	public Variable getVariableByCode(String code) {
		return getRepository().findByCode(code);
	}

	@Override
	protected VariableRepository getRepository() {
		return repository;
	}

}
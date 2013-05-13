package com.coopnex.odm.service;


import org.springframework.stereotype.Service;

import com.coopnex.odm.data.entity.Variable;
import com.coopnex.odm.data.repository.VariableRepository;
import com.coopnex.scrab.service.CrudService;

@Service
public class VariableService extends CrudService<Variable, Long>{


	public Variable getVariableByCode(String code) {
		return ((VariableRepository)getRepository()).findByCode(code);
	}

}
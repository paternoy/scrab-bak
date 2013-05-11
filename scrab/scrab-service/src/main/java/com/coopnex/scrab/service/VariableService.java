package com.coopnex.scrab.service;

import org.springframework.stereotype.Service;

import com.coopnex.scrab.data.entity.Variable;
import com.coopnex.scrab.data.repository.VariableRepository;

@Service
public class VariableService extends CrudService<Variable>{


	public Variable getVariableByCode(String code) {
		return ((VariableRepository)getRepository()).findByCode(code);
	}

}

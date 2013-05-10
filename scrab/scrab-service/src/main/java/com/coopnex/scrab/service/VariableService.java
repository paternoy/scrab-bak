package com.coopnex.scrab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coopnex.scrab.data.entity.Variable;
import com.coopnex.scrab.data.repository.VariableRepository;

@Service
public class VariableService {

	@Autowired
	VariableRepository variableRepository;

	public Variable getVariableByCode(String code) {
		return variableRepository.findByCode(code);
	}

	public List<Variable> getVariables() {
		return variableRepository.findAll();
	}

	@Transactional
	public Variable createVariable(Variable variable) {
		return variableRepository.saveAndFlush(variable);
	}
}

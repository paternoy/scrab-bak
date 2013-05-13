package com.coopnex.odm.data.repository;

import com.coopnex.odm.data.entity.Variable;
import com.coopnex.scrab.data.repository.AbstractRepository;

public interface VariableRepository extends AbstractRepository<Variable, Long> {

	Variable findByCode(String code);
	Variable findByName(String name);
}


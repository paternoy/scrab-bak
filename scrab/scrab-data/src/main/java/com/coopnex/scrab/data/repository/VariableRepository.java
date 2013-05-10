package com.coopnex.scrab.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coopnex.scrab.data.entity.Variable;

public interface VariableRepository extends JpaRepository<Variable, Long> {

	Variable findByCode(String code);
	Variable findByName(String name);
}

package com.coopnex.odm.data.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.coopnex.odm.data.entity.DataValue;
import com.coopnex.odm.data.entity.Variable;
import com.coopnex.scrab.data.repository.AbstractRepository;

public interface DataValueRepository extends AbstractRepository<DataValue, Long> {
	
	@Query("SELECT v FROM DataValue v WHERE v.variable = :variable AND v.dateTime BETWEEN :beginDateTime AND :endDateTime" )
	List<DataValue> findSeries(@Param("variable") Variable variable,
			@Param("beginDateTime") Date beginDateTime, @Param("endDateTime") Date endDateTime);
}


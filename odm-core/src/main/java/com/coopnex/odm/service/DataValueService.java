package com.coopnex.odm.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coopnex.odm.data.entity.DataValue;
import com.coopnex.odm.data.entity.Variable;
import com.coopnex.odm.data.repository.DataValueRepository;
import com.coopnex.odm.data.repository.VariableRepository;
import com.coopnex.odm.service.dto.SeriesDto;
import com.coopnex.scrab.service.CrudService;

@Service
public class DataValueService extends CrudService<DataValue, Long> {

	@Autowired
	DataValueRepository repository;

	@Autowired
	VariableRepository variableRepository;

	@Override
	protected DataValueRepository getRepository() {
		return repository;
	}

	@Transactional
	public SeriesDto getSeries(String variableCode, Date beginDateTime,
			Date endDateTime) {
		SeriesDto result = new SeriesDto();
		Variable variable = variableRepository.findByCode(variableCode);
		result.setVariable(variable);
		if (beginDateTime==null) beginDateTime = new Date(0);
		if (endDateTime==null) endDateTime = new Date();
		result.setBeginDateTime(beginDateTime);
		result.setEndDateTime(endDateTime);
		result.setValues(repository.findSeries(variable,beginDateTime,endDateTime));
		return result;
	}
	@Transactional
	public DataValue create(String variableCode, Date dateTime,float value) {
		Variable variable = variableRepository.findByCode(variableCode);
		DataValue dataValue = new DataValue();
		dataValue.setVariable(variable);
		dataValue.setDateTime(dateTime);
		dataValue.setValue(value);
		repository.saveAndFlush(dataValue);
		return dataValue;
	}
}
package com.coopnex.odm.service.dto;

import java.util.Date;
import java.util.List;

import com.coopnex.odm.data.entity.DataValue;
import com.coopnex.odm.data.entity.Variable;

public class SeriesDto {
	Variable variable;
	Date beginDateTime;
	Date endDateTime;
	List<DataValue> values;

	public Variable getVariable() {
		return variable;
	}

	public void setVariable(Variable variable) {
		this.variable = variable;
	}

	public Date getBeginDateTime() {
		return beginDateTime;
	}

	public void setBeginDateTime(Date beginDateTime) {
		this.beginDateTime = beginDateTime;
	}

	public Date getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	public List<DataValue> getValues() {
		return values;
	}

	public void setValues(List<DataValue> values) {
		this.values = values;
	}

}

package com.coopnex.restest.model;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.coopnex.restest.util.DateSerializer;

public class DataSeries {
	Date beginDate;
	Date endDate;
	float[] dataValues;
	Variable variable;

	@JsonSerialize(using=DateSerializer.class) 
	public Date getBeginDate() {
		return beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	
	@JsonSerialize(using=DateSerializer.class) 
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public float[] getDataValues() {
		return dataValues;
	}

	public void setDataValues(float[] dataValues) {
		this.dataValues = dataValues;
	}

	public Variable getVariable() {
		return variable;
	}

	public void setVariable(Variable variable) {
		this.variable = variable;
	}

}

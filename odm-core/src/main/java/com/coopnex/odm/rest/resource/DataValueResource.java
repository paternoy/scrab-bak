package com.coopnex.odm.rest.resource;

import java.util.Date;

import com.coopnex.odm.data.entity.DataValue;
import com.coopnex.scrab.rest.resource.AbstractResource;

public class DataValueResource extends AbstractResource<DataValue> {

	private Date dateTime;
	private Float value;

	public DataValueResource() {
		super();
	}

	public DataValueResource(DataValue entity) {
		super();
		dateTime = entity.getDateTime();
		value = entity.getValue();
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

}
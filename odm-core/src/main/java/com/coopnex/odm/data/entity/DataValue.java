package com.coopnex.odm.data.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.coopnex.scrab.data.entity.AbstractEntity;

@Entity
@Table
public class DataValue extends AbstractEntity<Long> {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;

	@Column
	Float value;

	@ManyToOne
	@JoinColumn(name = "variableId")
//	@MapsId("variableID")
	Variable variable;

	@Column
	@Temporal(TemporalType.TIMESTAMP)  
	Date dateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public Variable getVariable() {
		return variable;
	}

	public void setVariable(Variable variable) {
		this.variable = variable;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	@Override
	public String toString() {
		return "DataValue [id=" + id + ", value=" + value + ", variable="
				+ variable + ", dateTime=" + dateTime + "]";
	}

}

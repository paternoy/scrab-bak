package com.coopnex.scrab.rest.resource;

import java.io.Serializable;

import org.springframework.hateoas.ResourceSupport;

import com.coopnex.scrab.data.entity.AbstractEntity;

public abstract class AbstractResource<T extends AbstractEntity<? extends Serializable>> extends ResourceSupport{
	
	public AbstractResource() {
		super();
	}
}

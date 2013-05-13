package com.coopnex.scrab.rest.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.coopnex.scrab.service.CrudService;


public class CrudController<T,PK extends Serializable>{
	
	@Autowired
	CrudService<T,PK> service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	T getById(@PathVariable PK id) {
		return service.read(id);

	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	List<T> getAll() {
		return service.readAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody
	T create(@PathVariable long id,@RequestBody T element) {
		return service.create(element);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	void delete(@PathVariable PK id) {
		service.delete(id);
	}

	protected CrudService<T,PK> getService() {
		return service;
	}
	
}

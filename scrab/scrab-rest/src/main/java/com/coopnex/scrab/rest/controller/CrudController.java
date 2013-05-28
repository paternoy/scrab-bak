package com.coopnex.scrab.rest.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.coopnex.scrab.service.CrudService;


public abstract class CrudController<T,PK extends Serializable>{
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	T getById(@PathVariable PK id) {
		return getService().read(id);

	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	List<T> getAll() {
		return getService().readAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public @ResponseBody
	T create(@PathVariable long id,@RequestBody T element) {
		//FIXME: use id
		return getService().create(element);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED )
	public void add(@RequestBody T element) {
		getService().create(element);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	void delete(@PathVariable PK id) {
		getService().delete(id);
	}

	protected abstract CrudService<T,PK> getService();
	
}

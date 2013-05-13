package com.coopnex.scrab.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public abstract class CrudService<T, PK extends Serializable> {

	@Autowired
	JpaRepository<T, PK> repository;

	@Transactional
	public T create(T entity) {
		return repository.saveAndFlush(entity);
	}

	@Transactional
	public void delete(T entity) {
		repository.delete(entity);
	}

	@Transactional
	public void delete(PK entity) {
		repository.delete(entity);
	}

	@Transactional
	public T read(PK id) {
		return repository.findOne(id);
	}

	@Transactional
	public T save(T entity) {
		return repository.saveAndFlush(entity);
	}

	@Transactional
	public List<T> readAll() {
		return repository.findAll();
	}

	protected JpaRepository<T, PK> getRepository() {
		return repository;
	}

}

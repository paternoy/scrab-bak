package com.coopnex.scrab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CrudService<T> {


	@Autowired
	 JpaRepository<T,Long> repository;
	
	@Transactional
	public T create(T entity) {
		return repository.saveAndFlush(entity);
	}
	
	@Transactional
	public void delete(T entity) {
		repository.delete(entity);
	}

	@Transactional
	public T read(Long id) {
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
	
	protected JpaRepository<T, Long> getRepository() {
		return repository;
	}
	
	
	
}

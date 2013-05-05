package com.coopnex.restest.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coopnex.restest.entity.Variable;

@Service
public class VariableService {

	
	EntityManager em;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	public Variable getVariableByCode(String code){
		Query query = em.createQuery("SELECT v FROM Variable v WHERE v.code=:code");
		query.setParameter("code", code);
		return (Variable) query.getSingleResult();
	}

	public List<Variable> getVariables() {
		Query query = getEntityManager().createQuery("select v from Variable v");
		return query.getResultList();
	}
	
	@Transactional
	public Variable createVariable(Variable variable){
		getEntityManager().persist(variable);
		getEntityManager().flush();
		return variable;
	}

	
	public EntityManager getEntityManager() {
		return em;
	}
}

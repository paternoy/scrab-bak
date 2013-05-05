package com.coopnex.restest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coopnex.restest.entity.Variable;

@Repository
public class VariableDao {
	protected EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Transactional
	public List<Variable> getVariables() throws DataAccessException {
		Query query = getEntityManager()
				.createQuery("select v from Variable v");
		List<Variable> resultList = query.getResultList();
		return resultList;
	}

	@Transactional
	public Variable getVariableByCode(String code) throws DataAccessException {
		Query query = getEntityManager().createQuery(
				"select v from Variable v where code=:code");
		query.setParameter("code", code);
		Variable result;
		try {
			result = (Variable) query.getSingleResult();
			return result;
		} catch (NoResultException e) {
			return null;
		}
	}
}

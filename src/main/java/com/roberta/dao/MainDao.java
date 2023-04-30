package com.roberta.dao;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.criterion.CriteriaQuery;
import org.springframework.transaction.annotation.Transactional;

import com.roberta.model.Utilizator;

public abstract class MainDao<T> {

	@PersistenceContext(unitName="punit")
	protected EntityManager entityManager;
	
	private Class<T> classType;

    public MainDao(Class<T> classType){
    	this.classType=classType;
    }
    
    protected EntityManager getEntityManager(){
    	return this.entityManager;
    }
    
	@Transactional
    public void create(T entity){
    	this.entityManager.persist(entity );
    	this.entityManager.flush();
    
    }
	@Transactional
	public void update(T entity){
		this.entityManager.merge(entity);
		this.entityManager.flush();
	}
	
	@Transactional
	public void delete(T entity){
		this.entityManager.remove(entity);
	}
	
	@Transactional 
	public T findById(Long id){
		return this.entityManager.find(this.classType, id);
	}
	
	@Transactional
	public List<T> findAll(){
		
		   return entityManager.createQuery("Select t from " + classType.getSimpleName() + " t").getResultList();
	}
}

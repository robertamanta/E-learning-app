package com.roberta.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.roberta.model.Profesor;
import com.roberta.model.Utilizator;
@Repository("profesorDao")
public class ProfesorDaoImpl extends MainDao<Profesor> implements ProfesorDao {

	public ProfesorDaoImpl() {
		super(Profesor.class);
		
	}


	public Profesor selectProfesor(String numeUtilizator){
		
	    CriteriaBuilder builder=this.entityManager.getCriteriaBuilder();
	    CriteriaQuery<Profesor> cq=builder.createQuery(Profesor.class);
	    Root<Profesor> profesor=cq.from(Profesor.class);
	    cq.select(profesor);
	    cq.where(builder.equal(profesor.get("numeUtilizator"),numeUtilizator));
	    List<Profesor> lista=this.entityManager.createQuery(cq).getResultList();
	    if(lista.isEmpty())
	    {
	    	return null;
	    }else{
	      return lista.get(0);
	    }
	}


	public Profesor insertProfesor(Profesor profesor) {
		this.entityManager.merge(profesor);
		return profesor;
	}
}

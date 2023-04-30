package com.roberta.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Transient;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.roberta.model.Capitol;
import com.roberta.model.Curs;
import com.roberta.model.Lectie;
import com.roberta.model.Utilizator;

@Repository("cursRepository")
public class CursDaoImpl extends MainDao<Curs> implements CursDao{

	public CursDaoImpl() {
		super(Curs.class);
	}

	public Curs getCurs(String idCurs) {
		    CriteriaBuilder builder=this.entityManager.getCriteriaBuilder();
		    CriteriaQuery<Curs> cq=builder.createQuery(Curs.class);
		    Root<Curs> curs=cq.from(Curs.class);
		    cq.select(curs);
		    cq.where(builder.equal(curs.get("idCurs"),idCurs));
		    List<Curs> cursuri=this.entityManager.createQuery(cq).getResultList();
		    if(cursuri.isEmpty())
		    {
		    	return null;
		    }else{
		    
		  //  System.out.println(found.getFirstName()+" "+foundUser.getLastName()+" "+foundUser.getEmail()+" "+foundUser.getPassword());
		    return cursuri.get(0);
		    }
		
	}

	@Transactional
	public Curs insereazaCurs(Curs curs) {
		this.update(curs);
		System.out.println(curs.getDenumireCurs());
		return curs;
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Curs> getCursuri(String numeUtilizator) {
		  List<Curs> cursuri=new ArrayList<Curs>();
		  
		  cursuri=this.entityManager.createQuery("select c from Curs c where c.profesor.numeUtilizator LIKE :utilizator",Curs.class)
		  .setParameter("utilizator", numeUtilizator)
		  .getResultList();
		  return cursuri;
		    }
	@Transactional
	public List<Curs> getAll(){
		return this.findAll();
	}
	
   @Transactional
	public Curs modificaCurs(Curs curs){
	
	for(Capitol c: curs.getCapitole())
	{
		this.entityManager.merge(c);
		for(Lectie l: c.getLectii()){
			this.entityManager.merge(l);
		}
	}
	 
   Curs cursUpdate= this.entityManager.merge(curs);
	 return cursUpdate;
	}
}


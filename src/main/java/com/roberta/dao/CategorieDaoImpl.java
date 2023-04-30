package com.roberta.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.roberta.model.CategorieCurs;
import com.roberta.model.TipUtilizator;

@Repository("categorieRepository")
public class CategorieDaoImpl extends MainDao<CategorieCurs> implements CategorieDao {

	public CategorieDaoImpl() {
		super(CategorieCurs.class);
		// TODO Auto-generated constructor stub
	}

	public CategorieCurs getCategorie(String denumireCategorie) {
	    CriteriaBuilder builder=this.entityManager.getCriteriaBuilder();
	    CriteriaQuery<CategorieCurs> cq=builder.createQuery(CategorieCurs.class);
	    Root<CategorieCurs> categorie=cq.from(CategorieCurs.class);
	    cq.select(categorie);
	    cq.where(builder.equal(categorie.get("denumireCategorie"),denumireCategorie));
	    List<CategorieCurs> categorii=this.entityManager.createQuery(cq).getResultList();
	    if(categorii.isEmpty())
	    {
	    	return null;
	    }else{
	    
	  //  System.out.println(found.getFirstName()+" "+foundUser.getLastName()+" "+foundUser.getEmail()+" "+foundUser.getPassword());
	    return categorii.get(0);
	    }
	}

	public List<CategorieCurs> getCategorii() {
		return this.findAll();
		
	}
	
	
}

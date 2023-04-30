package com.roberta.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.roberta.model.Capitol;
import com.roberta.model.Curs;

@Repository("capitolRepository")
public class CapitolDaoImpl extends MainDao<Capitol>implements CapitolDao{

	public CapitolDaoImpl() {
		super(Capitol.class);
		// TODO Auto-generated constructor stub
	}

  @Transactional
	public Capitol deleteCapitol(Long id){
		Capitol capitol=entityManager.find(Capitol.class, id);
	    this.delete(capitol);
		return capitol;
	}
@Transactional
public Capitol insertCapitol(Capitol capitol) {
    update(capitol);
	return capitol;
}

public Capitol getCapitol(Long idCapitol) {
	 Capitol c=null;
	 c=this.entityManager.createQuery("select c from Capitol c where c.idCapitol LIKE :id",Capitol.class)
			  .setParameter("id", idCapitol)
			  .getSingleResult();
	return c;
}

}

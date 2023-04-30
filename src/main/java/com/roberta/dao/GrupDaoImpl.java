package com.roberta.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.roberta.model.Curs;
import com.roberta.model.Grup;

@Repository("grupRepository")
public class GrupDaoImpl extends MainDao<Grup> implements GrupDao{
  
	public GrupDaoImpl() {
		super(Grup.class);
		// TODO Auto-generated constructor stub
	}

	@Transactional
	public Grup insertGrup(Grup grup) {
		
			this.update(grup);
			
			return grup;
		
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Grup> getGrupuri(String numeProfesor) {
		  List<Grup> grupuri=new ArrayList<Grup>();
		  
		  grupuri=this.entityManager.createQuery("select g from Grup g where g.profesorGrup.numeUtilizator LIKE :utilizator",Grup.class)
		  .setParameter("utilizator", numeProfesor)
		  .getResultList();
		  return grupuri;
		    }

}

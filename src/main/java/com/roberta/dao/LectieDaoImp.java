package com.roberta.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.roberta.model.Capitol;
import com.roberta.model.Lectie;
@Repository("lectieRepository")
public class LectieDaoImp extends MainDao<Lectie> implements LectieDao {

	public LectieDaoImp( ) {
		super(Lectie.class);
		// TODO Auto-generated constructor stub
	}

	@Transactional
	public Lectie deleteLectie(Long idLectie) {
		Lectie lectie=entityManager.find(Lectie.class, idLectie);
	    this.delete(lectie);
		return lectie;
		
	}
	@Transactional
	public Lectie insertLectie(Lectie lectie) {
		update(lectie);
		return lectie;
	}

}

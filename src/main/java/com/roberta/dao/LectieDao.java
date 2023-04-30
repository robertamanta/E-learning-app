package com.roberta.dao;

import com.roberta.model.Lectie;

public interface LectieDao {

	public Lectie deleteLectie(Long idLectie);
	public Lectie insertLectie(Lectie lectie);
}

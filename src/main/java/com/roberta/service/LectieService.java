package com.roberta.service;

import com.roberta.model.Lectie;

public interface LectieService {

	public Lectie stergereLectie(Long idLectie);
	public Lectie insereazaLectie(String denumireLectie,Long idCapitol);
}

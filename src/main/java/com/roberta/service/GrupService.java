package com.roberta.service;

import java.util.List;

import com.roberta.model.Grup;

public interface GrupService {

	public Grup adaugaGrup(Grup grup,String numeProfesor);
	
	public List<Grup> selectGrupuri(String numeProfesor);
}

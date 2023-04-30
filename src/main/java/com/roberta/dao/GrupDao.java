package com.roberta.dao;

import java.util.List;

import com.roberta.model.Grup;

public interface GrupDao {

	public Grup insertGrup(Grup grup);
	public List<Grup> getGrupuri(String numeProfesor);
}

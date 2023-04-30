package com.roberta.dao;

import java.util.List;

import com.roberta.model.Curs;

public interface CursDao {

	Curs getCurs(String idCurs);
	Curs insereazaCurs(Curs curs);
	List<Curs> getCursuri(String numeUtilizator);
	public List<Curs> getAll();
	public Curs modificaCurs(Curs curs);
}

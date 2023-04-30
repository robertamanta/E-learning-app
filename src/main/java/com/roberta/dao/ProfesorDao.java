package com.roberta.dao;

import com.roberta.model.Profesor;

public interface ProfesorDao {

	public Profesor selectProfesor(String numeUtilizator);
	public Profesor insertProfesor(Profesor profesor);
}

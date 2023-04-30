package com.roberta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roberta.dao.ProfesorDao;
import com.roberta.model.Profesor;
@Service("profesorService")
public class ProfesorServiceImpl implements ProfesorService{

	@Autowired
	ProfesorDao profesorDao;
	public Profesor preiaProfesor(String numeUtilizator) throws Exception {
	
		Profesor profesor=new Profesor();
		profesor=profesorDao.selectProfesor(numeUtilizator);
		return profesor;
	}

}

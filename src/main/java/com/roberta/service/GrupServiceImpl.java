package com.roberta.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roberta.dao.GrupDao;
import com.roberta.dao.ProfesorDao;
import com.roberta.dao.UtilizatorDao;
import com.roberta.model.Grup;
import com.roberta.model.Profesor;

@Service("grupService")
public class GrupServiceImpl implements GrupService{

	@Autowired
	GrupDao grupDao;
	
	@Autowired
	ProfesorDao profesorDao;
	
	public Grup adaugaGrup(Grup grup,String numeProfesor) {
		Grup g=null;
		Profesor p=profesorDao.selectProfesor(numeProfesor);
		if(grup!=null){
			grup.setProfesorGrup(p);
			g=grupDao.insertGrup(grup);
		}
		return g;
	}

	public List<Grup> selectGrupuri(String numeProfesor) {
		
		List<Grup> grupuri= new ArrayList<Grup>();
		grupuri=grupDao.getGrupuri(numeProfesor);
		return grupuri;
	}

}

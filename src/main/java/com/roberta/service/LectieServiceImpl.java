package com.roberta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roberta.dao.CapitolDao;
import com.roberta.dao.LectieDao;
import com.roberta.dao.MainDao;
import com.roberta.model.Capitol;
import com.roberta.model.Curs;
import com.roberta.model.Lectie;

@Service("lectieService")
public class LectieServiceImpl implements LectieService{

	@Autowired
	LectieDao lectieDao;
	
	@Autowired
	CapitolDao capitolDao;
	public Lectie stergereLectie(Long idLectie) {
		Lectie lectie=null;
		try{
		 lectie=lectieDao.deleteLectie(idLectie);
		}
		catch(Exception e){
			return null;
		}
		return lectie;
	}

	public Lectie insereazaLectie(String denumireLectie, Long idCapitol) {
		Lectie l=null;
		Lectie lectie=new Lectie();
		Capitol capitol=capitolDao.getCapitol(idCapitol);
		lectie.setCapitol(capitol);
		lectie.setDenumireLectie(denumireLectie);
	
		try {
			l=lectieDao.insertLectie(lectie);
		} catch (Exception e) {
			return null;
		}
		
		return l;
	}
}

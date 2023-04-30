package com.roberta.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.experimental.categories.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.roberta.dao.CategorieDao;
import com.roberta.dao.CursDao;
import com.roberta.dao.CursDaoImpl;
import com.roberta.dao.ProfesorDao;
import com.roberta.dao.UtilizatorDao;
import com.roberta.model.Capitol;
import com.roberta.model.CategorieCurs;
import com.roberta.model.Curs;
import com.roberta.model.Profesor;
import com.roberta.model.TipUtilizator;
import com.roberta.model.Utilizator;

import Utile.IdComparator;

@Service("cursService")
public class CursServiceImpl implements CursService{

	@Autowired
	CursDao cursDao;
	
	@Autowired
	CategorieDao categorieDao;
	
	@Autowired
	ProfesorService profesorService;
	
	public Curs SalveazaCurs(Curs curs,String numeUtilizator) throws Exception{
		
		if(existaCurs(curs.getIdCurs())){
			throw new Exception("Mai exista un curs cu acest cod!");
		}
		
		    Curs cursNou=new Curs();
		    cursNou.setIdCurs(curs.getIdCurs());
		    cursNou.setDenumireCurs(curs.getDenumireCurs());
		    cursNou.setDescriereCurs(curs.getDescriereCurs());
		    cursNou.setDurataCurs(curs.getDurataCurs());
		    cursNou.setPret(curs.getPret());
		    cursNou.setCaleImagine(curs.getCaleImagine());
			String denumireCategorie=curs.getCategorieCurs().getDenumireCategorie();		
			CategorieCurs categorie=categorieDao.getCategorie(denumireCategorie);
			if(categorie!=null){
				cursNou.setCategorieCurs(categorie);
			}else
			{
				cursNou.setCategorieCurs(curs.getCategorieCurs());
			}
			
			Profesor profesor=profesorService.preiaProfesor(numeUtilizator);
		    cursNou.setProfesor(profesor);
		    Curs c=cursDao.insereazaCurs(cursNou);
			return c;
				
	}
	public boolean existaCurs(String idCurs){
		
		Curs curs=cursDao.getCurs(idCurs);
		//System.out.println(user.getEmail());
		if(curs==null){
			return false;
		}
		if(curs.getIdCurs().equals(idCurs))
		{
			return true;
		}
			
		else
		{
			return false;
		}
	}
	public List<Curs> preiaCursuri(String numeProfesor) throws Exception {
		
		List<Curs> cursuri=new ArrayList<Curs>();
		cursuri=cursDao.getCursuri(numeProfesor);
		if(cursuri.isEmpty()) 
			throw new Exception("nu exista cursuri");
		
		return cursuri;
	}
	
	public Curs selectCurs(String idCurs) {
		 Curs curs = cursDao.getCurs(idCurs);
		return curs;
	}
	
	public List<Curs> preiaToateCursurile(){
		 return cursDao.getAll();
	}
	public Curs actualizareCurs(Curs curs) {
         return cursDao.modificaCurs(curs);
	}
	
	

}

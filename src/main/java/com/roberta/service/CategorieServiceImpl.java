package com.roberta.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roberta.dao.CategorieDao;
import com.roberta.model.CategorieCurs;
import com.roberta.model.Curs;

@Service("categorieService")
public class CategorieServiceImpl implements CategorieService{

	@Autowired
	CategorieDao categorieDao;
	
	public List<CategorieCurs> returneazaListaCategorii() throws Exception{
		
		List<CategorieCurs> categorii=new ArrayList<CategorieCurs>();
		categorii=categorieDao.getCategorii();
		if(categorii.isEmpty()) 
			throw new Exception("Nu a fost adaugat nici-un curs!");
		
		return categorii;
	}
}

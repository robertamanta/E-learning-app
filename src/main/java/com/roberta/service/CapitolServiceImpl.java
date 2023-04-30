package com.roberta.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roberta.dao.CapitolDao;
import com.roberta.dao.CategorieDao;
import com.roberta.dao.CursDao;
import com.roberta.model.Capitol;
import com.roberta.model.Curs;

@Service("capitolService")
public class CapitolServiceImpl implements CapitolService{

	@Autowired
	CapitolDao capitolDao;
	
	@Autowired
	CursDao cursDao;
	public Capitol stergeCapitol(Long id){
		Capitol capitol=null;
		try {
			capitol=capitolDao.deleteCapitol(id);
		} catch (Exception e) {
			return null;
		}
		return capitol;
	}

	public Capitol insereazaCapitol(String denumireCapitol,String idCurs) {
		Capitol c=new Capitol();
		Curs curs=cursDao.getCurs(idCurs);
		c.setCapitolCurs(curs);
		c.setDenumireCapitol(denumireCapitol);
	
		try {
			c=capitolDao.insertCapitol(c);
		} catch (Exception e) {
			return null;
		}
		return c;
	}
}

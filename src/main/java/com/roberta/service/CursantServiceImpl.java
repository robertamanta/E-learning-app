package com.roberta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roberta.dao.CursantDao;
import com.roberta.model.Cursant;

@Service("cursantService")
public class CursantServiceImpl implements CursantService {

	@Autowired
	CursantDao cursantDao;
	
	public List<Cursant> selectCursanti() {
		
		return cursantDao.getCursanti();
		
	}

	
}

package com.roberta.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roberta.dao.CursDao;
import com.roberta.dao.TestDao;
import com.roberta.model.Curs;
import com.roberta.model.Test;

@Service("testService")
public class TestServiceImpl implements TestService{

	@Autowired
	TestDao testDao;
	
	public List<Test> preiaTeste(String idCurs) throws Exception {
		List<Test> teste=new ArrayList<Test>();
		teste=testDao.getTeste(idCurs);
		if(teste.isEmpty()) 
			throw new Exception("nu exista teste");
		
		return teste;
	}

	
}

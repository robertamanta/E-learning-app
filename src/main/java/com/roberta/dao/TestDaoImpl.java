package com.roberta.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.roberta.model.Curs;
import com.roberta.model.Test;

@Repository("testRepository")
public class TestDaoImpl  extends MainDao<Test> implements TestDao{

	public TestDaoImpl() {
		super(Test.class);
		// TODO Auto-generated constructor stub
	}

	public List<Test> getTeste(String idCurs) {
	
		List<Test> teste=new ArrayList<Test>();
		  
		  teste=this.entityManager.createQuery("select t from Test t where t.cursTeste.idCurs LIKE :idCurs",Test.class)
		  .setParameter("idCurs", idCurs)
		  .getResultList();
		  return teste;
	}

	
}

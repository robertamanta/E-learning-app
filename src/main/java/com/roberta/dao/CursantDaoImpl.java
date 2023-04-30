package com.roberta.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.roberta.model.Cursant;

@Repository("cursantRepository")
public class CursantDaoImpl extends MainDao<Cursant> implements CursantDao {

	public CursantDaoImpl() {
		super(Cursant.class);
		// TODO Auto-generated constructor stub
	}

	@Transactional
	public List<Cursant> getCursanti() {
		return this.findAll();
	}

}

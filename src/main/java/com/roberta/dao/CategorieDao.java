package com.roberta.dao;

import java.util.List;

import com.roberta.model.CategorieCurs;

public interface CategorieDao  {

	CategorieCurs getCategorie(String denumireCategorie);
	List<CategorieCurs> getCategorii();
}

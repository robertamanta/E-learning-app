package com.roberta.dao;

import com.roberta.model.Capitol;

public interface CapitolDao {

	public Capitol deleteCapitol(Long id);
	
	public Capitol insertCapitol(Capitol capitol);
	
	public Capitol getCapitol(Long idCapitol);
}

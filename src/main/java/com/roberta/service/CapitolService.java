package com.roberta.service;

import com.roberta.model.Capitol;

public interface CapitolService {

	public Capitol stergeCapitol(Long id);
	public Capitol insereazaCapitol(String denumireCapitol,String idCurs);
}

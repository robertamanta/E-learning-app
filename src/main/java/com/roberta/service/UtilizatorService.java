package com.roberta.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.roberta.model.Utilizator;

public interface UtilizatorService {
	UserDetails loadUser(String username);
	boolean userExists(String username,String email);
	public Utilizator registerUser(Utilizator user) throws Exception ;
}

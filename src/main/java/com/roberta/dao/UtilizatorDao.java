package com.roberta.dao;

import com.roberta.model.Utilizator;

public interface UtilizatorDao {

	Utilizator findUser(String username);
	Utilizator insertUser(Utilizator user);
}

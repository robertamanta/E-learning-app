package com.roberta.dao;

import java.util.List;

import com.roberta.model.Test;

public interface TestDao {

	List<Test> getTeste(String idCurs);
}

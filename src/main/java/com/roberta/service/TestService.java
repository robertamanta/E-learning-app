package com.roberta.service;

import java.util.List;

import com.roberta.model.Test;

public interface TestService {

	List<Test> preiaTeste(String idCurs) throws Exception;
}

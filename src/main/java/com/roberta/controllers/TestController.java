package com.roberta.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.roberta.model.Test;
import com.roberta.service.TestService;

@Controller
public class TestController {

	@Autowired
	TestService testService;
	
	@RequestMapping(value = "/profesor/teste", method = RequestMethod.GET)
	public String getAdaugaCurs(Model model, Principal principal,@RequestParam String idCurs) {
		List<Test> teste = new ArrayList<Test>();
		try {
			teste=testService.preiaTeste(idCurs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("teste",teste );
		return "profesor/teste";
	}
	
	
}

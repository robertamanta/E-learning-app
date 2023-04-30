package com.roberta.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping(value="/helloworld")
	public String sayHello(Model model){
		model.addAttribute("greeting","Hello dear!");
		
		return "helloworld";
	}
}

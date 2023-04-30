package com.roberta.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.roberta.model.Curs;
import com.roberta.service.CursService;
@Controller
public class CursantController {

	@Autowired
	CursService cursService;
	@RequestMapping(value="/cursant/acasa",method=RequestMethod.GET)
	public String getProfesorHome(Model model,Principal principal){
		 HashMap<String,Set<Curs>> categoriiCursuri=new HashMap<String, Set<Curs>>();
		 //  List<CategorieCurs>categorii=new ArrayList<CategorieCurs>();
		   List<Curs> cursuri=new ArrayList<Curs>();
		   
		   try {
			cursuri=cursService.preiaCursuri("andrei");
			for(Curs c :cursuri){
				String denumireCategorie=c.getCategorieCurs().getDenumireCategorie();
				if(categoriiCursuri.containsKey(denumireCategorie)){
					categoriiCursuri.get(denumireCategorie).add(c);
				}
				else if(!categoriiCursuri.containsKey(denumireCategorie)){
					categoriiCursuri.put(denumireCategorie, new HashSet<Curs>());
					categoriiCursuri.get(denumireCategorie).add(c);
				}
				
			}
			
					
		} catch (Exception e) {
			model.addAttribute("cursuriInexistente", e.getMessage());
		}
		   model.addAttribute("categoriiCursuri",categoriiCursuri);   
			 
	return "cursant/acasaCursant";
	}
}

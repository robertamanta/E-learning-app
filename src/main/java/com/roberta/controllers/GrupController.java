package com.roberta.controllers;

import java.security.Principal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.roberta.model.Curs;
import com.roberta.model.Cursant;
import com.roberta.model.Grup;
import com.roberta.service.CursantService;
import com.roberta.service.GrupService;

@Controller
public class GrupController {
	
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();
	
	@Autowired
	GrupService grupService;
	
	@Autowired
	CursantService cursantService;

	@RequestMapping(value = "/profesor/grupuri", method = RequestMethod.GET)
	public String getGrupuri(Model model, Principal principal) {
		Grup grup =new Grup();
		List<Grup> grupuri=new ArrayList<Grup>();
		grupuri=grupService.selectGrupuri(principal.getName());
		model.addAttribute("grupuri", grupuri);
		return "profesor/grupuri";
	}

	@RequestMapping(value = "/profesor/adaugaGrup", method = RequestMethod.GET)
	public String getAdaugaGrup(Model model, Principal principal) {
		Grup grup =new Grup();
		grup.setIdGrup(randomString(9));
		model.addAttribute("grup",grup);
		model.addAttribute("numeUtilizator", principal.getName());
		String rol = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
		model.addAttribute("rol", rol);
		return "profesor/adaugaGrup";
	}
	
	@RequestMapping(value = "/profesor/adaugaGrup", method = RequestMethod.POST)
	public String setAdaugaGrup(@Valid Grup grup, Principal principal, BindingResult result) {
		if(!result.hasErrors()){
		 Grup grupAdaugat=new Grup();
		 grupAdaugat = grupService.adaugaGrup(grup, principal.getName());
	     return "redirect:/profesor/grupuri.html";
		}
		return "profesor/adaugaGrup";
		
	}
	
	@RequestMapping(value="/profesor/grupuri",method=RequestMethod.POST)
	public String setGrupuri(Model model,Grup grup){
		String idGrup=grup.getIdGrup();
		model.addAttribute("idGrup",idGrup);
		return "grup";
	}
	
	@RequestMapping(value = "/profesor/grup", method = RequestMethod.GET)
	public String getGrup(Model model, @RequestParam String idGrup) {
		List<Cursant>cursanti = new ArrayList<Cursant>();
		cursanti=cursantService.selectCursanti();
		for(Cursant c: cursanti){
			System.out.println(c.getNumeUtilizator());
		}
		model.addAttribute("cursanti",cursanti);
		return "profesor/grup";
	}

	
	String randomString( int len ){
	   StringBuilder sb = new StringBuilder( len );
	   for( int i = 0; i < len; i++ ) 
	      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
	   return sb.toString();
	}
}

package com.roberta.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.roberta.model.Utilizator;
import com.roberta.service.UtilizatorService;
import com.roberta.service.UtilizatorServiceImpl;
import com.roberta.validation.ValidareUtilizator;

@Controller
public class LoginController {

	@Autowired
	ValidareUtilizator userValidation;

	@Autowired
	UtilizatorService userService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage(Model model) {
		
		Utilizator utilizator = new Utilizator();
		model.addAttribute("utilizator", utilizator);
		return "login";

	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String getAdminPage(Model model) {
		return "admin";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			new SecurityContextLogoutHandler().logout(request, response, authentication);
		}
		return "redirect:/login?logout";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String getRegistration(Model model) {

		Utilizator utilizator = new Utilizator();
		model.addAttribute("utilizator", utilizator);

		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String setRegistration(@Valid Utilizator utilizator, BindingResult result, Model model) {
		System.out.println("resul has errors: "+result.hasErrors());

		userValidation.validate(utilizator, result);
		Utilizator regUser = null;
		if (result.hasErrors()) {
			return "registration";
		} else if (!result.hasErrors()) {
			regUser = new Utilizator();
			regUser = createUser(utilizator, result);
		}
		if (regUser == null) {
			model.addAttribute("userExists","Utilizator existent!");
		    return "registration";
		}
		
        model.addAttribute("regis",regUser);
		System.out.println("Utilizator: " + utilizator.getNumeUtilizator() );
      	return "redirect:/login?regis";
	}

	private Utilizator createUser(Utilizator utilizator, BindingResult bindingResult) {
		Utilizator newUser = null;

		try {
			newUser = userService.registerUser(utilizator);
		} catch (Exception e) {
			return null;
		}
       
		return newUser;
	}
}

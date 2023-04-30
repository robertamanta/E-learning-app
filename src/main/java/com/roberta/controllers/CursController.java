package com.roberta.controllers;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.roberta.model.Capitol;
import com.roberta.model.Curs;
import com.roberta.model.Fisier;
import com.roberta.model.Lectie;
import com.roberta.service.CapitolService;
import com.roberta.service.CursService;
import com.roberta.service.LectieService;

@Controller
public class CursController {

	@Autowired
	CursService cursService;

	@Autowired
	CapitolService capitolService;

	@Autowired
	LectieService lectieService;
	private static String LOCATIE_SALVARE = "D:/imagini/";

	

	@RequestMapping(value = "/profesor/adaugaCurs", method = RequestMethod.GET)
	public String getAdaugaCurs(Model model, Principal principal) {
		Curs curs = new Curs();
		model.addAttribute("curs", curs);
		model.addAttribute("numeUtilizator", principal.getName());
		String rol = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
		model.addAttribute("rol", rol);
		return "profesor/adaugaCurs";
	}

	@RequestMapping(value = "/profesor/adaugaCurs", method = RequestMethod.POST)
	public String setAdaugaCurs(@Valid Curs curs, Principal principal, BindingResult result,
			@RequestParam("file") MultipartFile file) {

		Curs cursNou = null;
		String extensie = file.getOriginalFilename().split("\\.")[1];

		if (!result.hasErrors()) {
			if (extensie.equalsIgnoreCase("jpg") || extensie.equalsIgnoreCase("png")) {

				{
					if (!file.isEmpty()) {
						try {
							byte[] bytes = file.getBytes();
							String caleImagine = LOCATIE_SALVARE + file.getOriginalFilename();

							FileCopyUtils.copy(file.getBytes(), new File(caleImagine));
							curs.setCaleImagine(caleImagine);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						cursNou = new Curs();
						cursNou = creeazaCurs(curs, principal.getName(), result);
					}
					if (cursNou == null) {
						return "profesor/adaugaCurs";
					}
				}
				return "redirect:/profesor/acasa.html";
			}
		}
		 
			return "profesor/adaugaCurs";

		
		
	}
	

	@RequestMapping(value = "/profesor/cursCreat", method = RequestMethod.GET)
	public String getCursCreat(Model model, @RequestParam String idCurs) {
		Curs curs = new Curs();
		// String id=request.getParameter("idCurs");

		curs = cursService.selectCurs(idCurs);
		System.out.println(curs.getDenumireCurs());

		model.addAttribute("curs", curs);
		return "profesor/cursCreatNou";
	}

	@RequestMapping(value = "/profesor/cursCreat", method = RequestMethod.POST)
	public String setCursCreat(@Valid Curs curs, Model model, BindingResult result, HttpServletRequest request) {

		if (result.hasErrors()) {
			System.out.println(result.getNestedPath());
			return "profesor/cursCreatNou";
		}
		String stergereCapitol = request.getParameter("stergereCapitol");
		String stergereLectie = request.getParameter("stergereLectie");
		String adaugareCapitol = request.getParameter("adaugaCapitol");
		String adaugareLectie = request.getParameter("adaugaLectie");
		String idCapitol = request.getParameter("idCapitol");

		if (stergereCapitol != null) {
			System.out.println(stergereCapitol);
			capitolService.stergeCapitol(Long.valueOf(stergereCapitol));
			model.addAttribute("idCurs", curs.getIdCurs());
			return "redirect:/profesor/cursCreat.html";
		} else if (stergereLectie != null) {
			System.out.println(stergereLectie);
			lectieService.stergereLectie(Long.valueOf(stergereLectie));
			model.addAttribute("idCurs", curs.getIdCurs());
			return "redirect:/profesor/cursCreat.html";
		} else if (!adaugareCapitol.equals("")) {
			System.out.println(adaugareCapitol);
			Capitol c = creeazaCapitol(adaugareCapitol, curs.getIdCurs());
			model.addAttribute("idCurs", curs.getIdCurs());
			return "redirect:/profesor/cursCreat.html";
		} else if (!adaugareLectie.equals("") || !idCapitol.equals("")) {
			System.out.println(adaugareLectie + " " + idCapitol);
			Lectie l = creeazaLectie(adaugareLectie, Long.valueOf(idCapitol));
			model.addAttribute("idCurs", curs.getIdCurs());
			return "redirect:/profesor/cursCreat.html";
		}

		else {
			Curs cursModificat = cursService.selectCurs(curs.getIdCurs());
			for (Capitol c : curs.getCapitole()) {
				c.setCapitolCurs(curs);
				;
				for (Lectie l : c.getLectii()) {
					l.setCapitol(c);
				}
			}
			cursModificat.setCapitole(curs.getCapitole());
			Curs cursNou = cursService.actualizareCurs(cursModificat);
			model.addAttribute("curs", cursNou);
			return "redirect:/profesor/acasa.html";
		}
	}

	private Curs creeazaCurs(Curs curs, String numeUtilizator, BindingResult bindingResult) {
		Curs cursNou = null;
		try {
			cursNou = cursService.SalveazaCurs(curs, numeUtilizator);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cursNou;
	}

	private Capitol creeazaCapitol(String denumireCapitol, String idCurs) {
		Capitol capitol = null;
		try {
			capitol = capitolService.insereazaCapitol(denumireCapitol, idCurs);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return capitol;
	}

	private Lectie creeazaLectie(String denumireLectie, Long idCapitol) {
		Lectie lectie = null;
		try {
			lectie = lectieService.insereazaLectie(denumireLectie, idCapitol);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return lectie;
	}
}

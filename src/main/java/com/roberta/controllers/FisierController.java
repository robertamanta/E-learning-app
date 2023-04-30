package com.roberta.controllers;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.roberta.model.Lectie;
import com.roberta.model.Resursa;

@Controller
public class FisierController {

	private static String LOCATIE_SALVARE="D:/Licenta/imagini/";
	
//	 @RequestMapping(value = "/incarcare", method = RequestMethod.GET)
//	    public String getSingleUploadPage(ModelMap model) {
//	        Fisier fisier = new Fisier();
//	        model.addAttribute("fisierIncarcat", fisier);
//	        return "profesor/upload";
//	    }
//	 
//	    @RequestMapping(value = "/incarcare", method = RequestMethod.POST)
//	    public String singleFileUpload( Fisier fisier,
//	            BindingResult result, ModelMap model) throws IOException {
//	 
//	        if (result.hasErrors()) {
//	            System.out.println("validation errors");
//	            return "singleFileUploader";
//	        } else {
//	            System.out.println("Fetching file");
//	           
//	            try {
////	    			imaginePrimita.createNewFile();
////	    			FileOutputStream fos=new FileOutputStream(imaginePrimita);
////	    			fos.write(imagine.getBytes());
//	            	MultipartFile fisierIncarcat=fisier.getFisier();
//	            	String numeFisier = fisierIncarcat.getOriginalFilename();
//	    			FileCopyUtils.copy(fisier.getFisier().getBytes(), new File( LOCATIE_SALVARE + numeFisier));
//	    	        model.addAttribute("numeFisier", numeFisier);
////	    			File destinatie=new File(caleImagine);
////	    			img.transferTo(destinatie);
//	    		} catch (IOException e) {
//	    			// TODO Auto-generated catch block
//	    			e.printStackTrace();
//	    		}
//	            return "profesor/incarcare";
//	        }
//	    }
	
	 @RequestMapping(value = "/profesor/incarcareResursa", method = RequestMethod.GET)
	    public String getSingleUploadPage(Model model,@RequestParam String idLectie) {
		 	System.out.println("idLectie "+idLectie);
		 	Resursa resursa=new Resursa();
		 	model.addAttribute(resursa);
	        return "profesor/upload";
	    }
	  @RequestMapping(value = "/profesor/incarcareResursa", method = RequestMethod.POST)
	    public String handleFormUpload(Resursa resursa,@RequestParam("fisier") MultipartFile fisier,@RequestParam String idLectie) throws IOException {

	        if (!fisier.isEmpty()) {
	            byte[] bytes = fisier.getBytes();
	            String caleResursa=LOCATIE_SALVARE + fisier.getOriginalFilename();
	            FileCopyUtils.copy(fisier.getBytes(), new File(caleResursa));
	            resursa.setCaleResursa(caleResursa);
	            Lectie l=new Lectie();
	            l.setIdLectie(Long.valueOf(idLectie));
	            resursa.setLectieResursa(l);
	           return "redirect:/profesor/acasa.html";
	       } else {
	           return "profesor/upload";
	       }
	    }

	 
}

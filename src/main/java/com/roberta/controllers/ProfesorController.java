package com.roberta.controllers;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mysql.jdbc.Buffer;
import com.roberta.model.CategorieCurs;
import com.roberta.model.Curs;
import com.roberta.service.CategorieService;
import com.roberta.service.CursService;

@Controller
public class ProfesorController {

	private ResourceLoader resourceLoader;
	@Autowired
	CategorieService categorieService;
	
	@Autowired
	CursService cursService;
	
	@Autowired
	ApplicationContext appContext;
	
	@RequestMapping(value = "/imagine", method=RequestMethod.GET)
	public void afiseazaImagine(Model model,@RequestParam("idCurs") String idCurs, HttpServletResponse response) throws FileUploadException {
		
		
		BufferedImage img = null;
		String caleImagine=cursService.selectCurs(idCurs).getCaleImagine();
	    String [] split = null;
	    split=caleImagine.split("\\.");

		try 
		{
		    img = ImageIO.read(new File(caleImagine)); // eventually C:\\ImageTest\\pic2.jpg
		    ByteArrayOutputStream baos=new ByteArrayOutputStream();
		    if(split[1].equalsIgnoreCase("jpg")){
		    	 ImageIO.write(img, "jpg", baos);
				 response.setContentType("image/jpg");
		    }else
		    	if(split[1].equalsIgnoreCase("png")){
		    		 ImageIO.write(img, "png", baos);
					 response.setContentType("image/png");
		    	}
		    	
		   
		    byte[] bytes = baos.toByteArray();
		    String encodedImg=new String(bytes);
			model.addAttribute("img",encodedImg);
			response.setContentLength(bytes.length);
			OutputStream out=response.getOutputStream();
			out.write(bytes);
			out.close();
			baos.close();
		} 
		catch (IOException e) 
		{
		    e.printStackTrace();
		}
		
		
		
	}
	
	@RequestMapping(value="/profesor/acasa",method=RequestMethod.GET)
	public String getProfesorHome(Model model,Principal principal){
	
	   String profesor=principal.getName();
	   model.addAttribute("numeProfesor", profesor);
	   
	   HashMap<String,Set<Curs>> categoriiCursuri=new HashMap<String, Set<Curs>>();
	   List<Curs> cursuri=new ArrayList<Curs>();
	   
	   try {
		cursuri=cursService.preiaCursuri(profesor);
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
	   return "profesor/profesorHomeNou";
	   
	}
	
	@RequestMapping(value="/profesor/acasa",method=RequestMethod.POST)
	public String setProfesorHome(Model model,Curs curs){
		String id=curs.getIdCurs();
		model.addAttribute("idCurs",id);
		return "cursCreat";
	}


}

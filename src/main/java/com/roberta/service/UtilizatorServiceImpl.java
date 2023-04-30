package com.roberta.service;

import java.util.Collection;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.roberta.dao.UtilizatorDao;
import com.roberta.dao.UtilizatorDaoImpl;
import com.roberta.dao.ProfesorDao;
import com.roberta.dao.TipUtilizatorDao;
import com.roberta.model.Utilizator;
import com.roberta.model.Administrator;
import com.roberta.model.Cursant;
import com.roberta.model.Profesor;
import com.roberta.model.TipUtilizator;

@Service("userService")
public class UtilizatorServiceImpl implements UtilizatorService {

	@Autowired
	private UtilizatorDao userDao;
	
	@Autowired
	private TipUtilizatorDao userTypeDao;

	@Autowired
	private ProfesorDao profesorDao;
	public UserDetails loadUser(String username){
		
		Utilizator user=userDao.findUser(username);
		if(user==null)
			throw new UsernameNotFoundException("Numele de utilizator inexistent!");
		
		return (UserDetails) user;
		
	}


	public Utilizator registerUser(Utilizator utilizator) throws Exception {
		if (userExists(utilizator.getNumeUtilizator(), utilizator.getEmail()))
		 throw new Exception("Utilizator existent!");
		
		Utilizator newUser=null;
		if(utilizator.getTipUtilizator().getTip().equals("profesor"))	{
		
		newUser=new Profesor();
		}
		else if(utilizator.getTipUtilizator().getTip().equals("cursant"))
		{
			newUser=new Cursant();
		}
		else 
		newUser=new Utilizator();
		newUser.setNume(utilizator.getNume());
		newUser.setPrenume(utilizator.getPrenume());
		newUser.setParola(utilizator.getParola());
		newUser.setEmail(utilizator.getEmail());
		newUser.setNumeUtilizator(utilizator.getNumeUtilizator());
		newUser.setPotrivireParola(utilizator.getPotrivireParola());
		newUser.setDescriere(utilizator.getDescriere());
		String type=utilizator.getTipUtilizator().getTip();
		TipUtilizator userType=userTypeDao.findType(type);
		if(userType!=null){
			newUser.setTipUtilizator(userType);
		}else{
		newUser.setTipUtilizator(utilizator.getTipUtilizator());
		}
		return userDao.insertUser(newUser);
		
		
	}
	
	public boolean userExists(String username,String email){
		Utilizator user=userDao.findUser(username);
		//System.out.println(user.getEmail());
		if(user==null){
			return false;
		}
		if(user.getNumeUtilizator().equals(username)||user.getEmail().equals(email))
		{
			System.out.println(true);
			return true;
		}
			
		else
		{
			System.out.println(false);
			return false;
		}
	}
}

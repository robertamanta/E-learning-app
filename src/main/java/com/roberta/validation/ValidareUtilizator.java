package com.roberta.validation;

import java.net.PasswordAuthentication;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.roberta.model.Utilizator;
@Component
public class ValidareUtilizator implements Validator{

	public boolean supports(Class<?> clasa) {
		return Utilizator.class.isAssignableFrom(clasa);
	
	}

	public void validate(Object obj, Errors err) {
		
		Utilizator utilizator=(Utilizator)obj;
		String password=utilizator.getParola();
		String passwordMatch=utilizator.getPotrivireParola();
		if(!password.equals(passwordMatch)){
			err.rejectValue("passwordMatch","ValidareUtilizator.password.match","Parolele nu coincid!");
		}
		
	}

}

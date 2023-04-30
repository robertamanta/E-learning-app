package com.roberta.configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class SuccessAuthHandler implements AuthenticationSuccessHandler{

	private RedirectStrategy redirectStrategy= new DefaultRedirectStrategy();
	
	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse resp, Authentication authentication)
			throws IOException, ServletException {
	
		String url=determinaURL(authentication);
		if(resp.isCommitted()){
			 System.out.println("Nu se poate face redirectarea");
	            return;
		}
		
		redirectStrategy.sendRedirect(req, resp, url);
		
	}
	
	protected String determinaURL(Authentication authentication){
		
		String url="";
		List<String> roluri=new ArrayList<String>();
	    Collection<? extends GrantedAuthority> auth = authentication.getAuthorities();
	    for(GrantedAuthority ga:auth){
	    	roluri.add(ga.getAuthority());
	    }
	    if(roluri.contains("ADMIN")){
	       url="/admin.html";
	    }else
	    	if(roluri.contains("PROFESOR")){
	    		url="/profesor/acasa.html";
	    		
	    	}else
	    		if(roluri.contains("CURSANT"))
	    			url="/cursant/acasa.html";
	    		else {
	    			url="/helloworld.html";
	    		}
	    return url;    		
		
	}

	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}
	
    
}

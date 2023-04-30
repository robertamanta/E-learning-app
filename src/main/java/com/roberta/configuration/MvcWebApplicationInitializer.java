package com.roberta.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MvcWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer implements WebApplicationInitializer  {

	
	public void onStartup(ServletContext svContext) throws ServletException {
		
		WebApplicationContext context=getContext();
		svContext.addListener(new ContextLoaderListener(context));
		ServletRegistration.Dynamic dispatcher=svContext.addServlet("DispatcherServlet",new DispatcherServlet(context));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("*.html");
	    
		
	}

	public AnnotationConfigWebApplicationContext getContext() {
		
		AnnotationConfigWebApplicationContext ctx=new AnnotationConfigWebApplicationContext();
		ctx.setConfigLocation("com.roberta.configuration.WebConfig");
		return ctx;

	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class[]{SecurityConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String [] {"/"};
	}




}

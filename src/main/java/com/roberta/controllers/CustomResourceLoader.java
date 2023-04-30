package com.roberta.controllers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class CustomResourceLoader implements ResourceLoaderAware {

	  private ResourceLoader resourceLoader;
	  
	    public void setResourceLoader(ResourceLoader resourceLoader) {
	        this.resourceLoader = resourceLoader;
	        
	    }
	    
	 
	  
}

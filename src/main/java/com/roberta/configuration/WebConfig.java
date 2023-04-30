package com.roberta.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.AbstractHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import com.roberta.validation.ValidareUtilizator;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.roberta")
public class WebConfig extends WebMvcConfigurerAdapter{
	
	@Bean
	public InternalResourceViewResolver getInternalResourceViewResolver(){
		
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	@Bean
	public ValidareUtilizator validareUtilizator(){
		return new ValidareUtilizator();
	}
	
	@Bean(name="multipartResolver")
	public CommonsMultipartResolver getResolver(){
		 CommonsMultipartResolver resolver=new CommonsMultipartResolver();
	     resolver.setMaxUploadSize(5242880);
	     return resolver;
	//	return new StandardServletMultipartResolver();
	}

@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry
      .addResourceHandler("/fisiere/**")
      .addResourceLocations("/imagini/");
       super.addResourceHandlers(registry);
 }

//@Override
//public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//    configurer.enable();
//}
}
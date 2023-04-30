package com.roberta.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private SuccessAuthHandler successHandler;
	
	@Autowired
	public void confGlobal(AuthenticationManagerBuilder builder) throws Exception{
		
			//builder.inMemoryAuthentication().withUser("ana").password("ana").roles("ADMIN");
		builder
		.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("select nume_utilizator,parola,stare from utilizatori where nume_utilizator=?")
			.authoritiesByUsernameQuery("select nume_utilizator, rol from utilizatori u, roluri r where r.id_rol=u.id_rol and nume_utilizator=?");
	}
	
//	 @Override
//	  public void configure(WebSecurity web) throws Exception {
//	    web
//	      .ignoring()
//	         .antMatchers("/resources/**"); // #3
//	  }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/bootstrap/**", "/registration.html","/fisiere/**").permitAll()                 
		.antMatchers("/admin.html").hasAuthority("ADMIN")
		.antMatchers("/profesor/**","/imagine/**").hasAuthority("PROFESOR")
		.antMatchers("/cursant/**","/imagine/**").hasAuthority("CURSANT")        
		.anyRequest().authenticated()                                                   
		.and()
			.formLogin()
			.loginPage("/login.html").passwordParameter("parola").usernameParameter("numeUtilizator")
		    .permitAll()
		    .successHandler(successHandler)
		    .and()
		    .logout().permitAll();
				
				
	}
}

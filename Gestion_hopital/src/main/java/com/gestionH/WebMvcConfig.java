package com.gestionH;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
public class WebMvcConfig extends  WebMvcConfigurerAdapter{

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
		registry.addViewController("patient/home").setViewName("rendezvous/accueil");
		registry.addViewController("patient/accueil").setViewName("rendezvous/index");
		registry.addViewController("/").setViewName("login");
	}
}

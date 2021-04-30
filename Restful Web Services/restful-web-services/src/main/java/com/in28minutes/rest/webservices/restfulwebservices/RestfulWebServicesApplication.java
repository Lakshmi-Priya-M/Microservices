package com.in28minutes.rest.webservices.restfulwebservices;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class RestfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}
	
	@Bean
	public LocaleResolver localeResolver() {
		//SessionLocaleResolver localresolver = new SessionLocaleResolver();
		AcceptHeaderLocaleResolver localresolver = new AcceptHeaderLocaleResolver();
		localresolver.setDefaultLocale(Locale.US);
		return localresolver;
	}
	
	//instead of this, we can set it in application.properties
	
//	@Bean
//	public ResourceBundleMessageSource messageSource() {
//		ResourceBundleMessageSource bundlemessageSource = new ResourceBundleMessageSource	();
//		bundlemessageSource.setBasename("messages");
//		return bundlemessageSource;
//	}	

}

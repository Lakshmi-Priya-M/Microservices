package com.in28minutes.rest.webservices.restfulwebservices.helloWorld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
/*import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;*/
import org.springframework.web.bind.annotation.RestController;

// a service which returns the text "hello world"
@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;

	/*
	 * @RequestMapping(method = RequestMethod.GET, path = "/hello-world") public
	 * String helloworld() { return "hello world"; }
	 */
	@GetMapping(path = "/hello-world")
	public String helloworld() {
		return "hello world";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloworldBean() {
		return new HelloWorldBean("Hello world");
	}
	
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloworldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello World , %s", name));
	}
	
	/*@GetMapping(path = "/hello-world-internalization")
	public String helloworldInternalization(@RequestHeader(name = "Accept-Language", required=false) Locale locale) {
		return messageSource.getMessage("good.morning.message", null, locale);
	}*/
	
	@GetMapping(path = "/hello-world-internalization")
	public String helloworldInternalization() {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
}

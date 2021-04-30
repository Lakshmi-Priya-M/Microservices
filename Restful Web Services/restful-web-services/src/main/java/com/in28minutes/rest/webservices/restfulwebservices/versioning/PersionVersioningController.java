package com.in28minutes.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersionVersioningController {
	
	@GetMapping("v1/person")
	public Personv1 personv1()
	{
		return new Personv1("Lakshmi");
	}
	
	@GetMapping("v2/person")	
	public Personv2 personv2()
	{
		return new Personv2(new Name("Lakshmi", "Priya"));
	}
	
	@GetMapping(value = "person/param", params = "version=1")	
	public Personv1 paramv1()
	{
		return new Personv1("Lakshmi");
	}
	
	@GetMapping(value = "person/param", params = "version=2")	
	public Personv2 paramv2()
	{
		return new Personv2(new Name("Lakshmi", "Priya"));
	}
	
	@GetMapping(value = "person/header", headers = "X-API-VERSION=1")	
	public Personv1 headerv1()
	{
		return new Personv1("Lakshmi");
	}
	
	@GetMapping(value = "person/header", headers = "X-API-VERSION=2")	
	public Personv2 headerv2()
	{
		return new Personv2(new Name("Lakshmi", "Priya"));
	}
	
	@GetMapping(value = "person/produces", produces = "application/vnd.company.app-v1+json")	
	public Personv1 producesv1()
	{
		return new Personv1("Lakshmi");
	}
	//produces is sent as accept headers
	@GetMapping(value = "person/produces", produces = "application/vnd.company.app-v2+json")	
	public Personv2 producesv2()
	{
		return new Personv2(new Name("Lakshmi", "Priya"));
	}



}

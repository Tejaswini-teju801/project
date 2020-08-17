package com.demo.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController 
{
@RequestMapping("/greetings")
	public String dispMsg()
	{
		return "welcome all to spring boot";
	}
	
	
	
	
}

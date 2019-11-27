package com.appointment.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/index")
	public String Hello() {
		System.out.println("Hello Executing");
		return "index";
	}
	
	@GetMapping("/")
	public String Welcome() {
		
	return"error";
	}

}

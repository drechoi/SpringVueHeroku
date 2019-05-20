package com.example.demo.controller;

import org.jboss.logging.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	Logger logger = Logger.getLogger(DemoController.class);

	@GetMapping("/api/")
	public String index(){
		logger.info("index");
		return "This is server index"; 		
	}
}

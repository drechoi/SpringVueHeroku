package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Scheme;
import com.example.demo.repository.SchemeRepository;

@Controller
@RequestMapping("${api_prefix}/scheme")
public class SchemeController {
	@Autowired
	private SchemeRepository schemeRepository;
	
	@PostMapping("/create")
	public void createScheme(Scheme scheme){
		schemeRepository.save(scheme);
	}
	
	public Scheme getScheme(String loginToken){
		return null;
	}
}

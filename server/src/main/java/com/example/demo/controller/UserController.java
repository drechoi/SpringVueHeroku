package com.example.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AppUser;
import com.example.demo.model.dto.UserInfoDTO;
import com.example.demo.service.UserService;

@RestController
@RequestMapping(path="${api_prefix}/user")
public class UserController {	
	Logger logger = LoggerFactory.getLogger(UserController.class);
		
	@Autowired
	private UserService userService;    
	
    @PostMapping("/login")
    public UserInfoDTO login(@RequestBody AppUser user){
    	return userService.getUserInfoDTOFromUser(userService.getOrCreateAppUser(user));
    }
}

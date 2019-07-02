package com.example.demo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.AppException;
import com.example.demo.model.AppUser;
import com.example.demo.model.dto.UserInfoDTO;
import com.example.demo.service.LoginService;
import com.example.demo.service.UserService;

@RestController
@RequestMapping(path="${api_prefix}/user")
public class UserController {	
	Logger logger = LoggerFactory.getLogger(UserController.class);
		
	@Autowired
	private UserService userService;
	
	@Autowired
	private LoginService loginService;
	
	// Here do login and register
    @PostMapping("/login")
    public boolean login(@RequestBody AppUser user) throws AppException{
    	// TODO: change it to login and register
    	// get profile will be called by another function 
    	// return userService.getUserInfoDTOFromUser(userService.getOrCreateAppUser(user));
    	return loginService.loginOrRegister(user, user.getLoginToken(), user.getLoginTokenExpiry());
    }
    
    @PostMapping("/logout")
    public void logout(@RequestBody AppUser user) throws AppException{
    	long userId = user.getId();
    	loginService.logout(userId);
    }
    
    public Object getUserProfile(String token) {
    	return null;
    }
}

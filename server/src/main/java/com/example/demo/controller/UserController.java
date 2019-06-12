package com.example.demo.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AppUser;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping(path="${api_prefix}/user")
public class UserController {	
	Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create")
    public AppUser createUser(@RequestBody AppUser user){
        String extId = user.getExtId();
        List<AppUser> users = userRepository.findByExtId(extId);
        if(users.size() == 0){
            return userRepository.save(user);
        }
        return users.get(0);
    }

    @GetMapping("/find/{extId}")
    public AppUser findUserByExternalId(@PathVariable String extId){
        List<AppUser> users = userRepository.findByExtId(extId);
        return users != null && users.size() > 0 ? users.get(0): null;
    }
    
    @PostMapping("/login")
    public AppUser login(@RequestBody AppUser user){
    	String extId = user.getExtId();    	
        List<AppUser> users = userRepository.findByExtId(extId);
        if(users.size() == 0){
        	logger.debug("User not found, create new one. Ext ID=" + user.getExtId());
            return userRepository.save(user);
        }
        logger.debug("User found");
        return users.get(0);    	
    }
}

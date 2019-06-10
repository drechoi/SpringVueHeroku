package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping(path="${api_prefix}/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/create")
    public User createUser(@RequestBody User user){
        String extId = user.getExtId();
        List<User> users = userRepository.findByExtId(extId);
        if(users.size() == 0){
            return userRepository.save(user);
        }
        return users.get(0);
    }

    @GetMapping("/find/{extId}")
    public User findUserByExternalId(@PathVariable String extId){
        List<User> users = userRepository.findByExtId(extId);
        return users != null && users.size() > 0 ? users.get(0): null;
    }
    
    @PostMapping("/login")
    public User login(@RequestBody User user){
    	String extId = user.getExtId();    	
        List<User> users = userRepository.findByExtId(extId);
        if(users.size() == 0){
            return userRepository.save(user);
        }
        return users.get(0);    	
    }
}

package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="${api_prefix}/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/ext/{extId}")
    public User findUserByExternalId(@PathVariable String extId){
        List<User> users = userRepository.findByExtId(extId);
        return users != null && users.size() > 0 ? users.get(0): null;
    }
}

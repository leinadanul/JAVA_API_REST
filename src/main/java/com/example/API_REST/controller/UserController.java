package com.example.API_REST.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.API_REST.model.User;
import com.example.API_REST.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
    
    @Autowired
    UserService userService;
    

    @RequestMapping(value="/users", method = RequestMethod.POST)
    public User createUser(@RequestBody User usr){
        return userService.createUser(usr);

    }
}

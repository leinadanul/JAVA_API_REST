package com.example.API_REST.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
    

    @RequestMapping(value="/user", method=RequestMethod.POST)
    public User createUser(@RequestBody User usr){
        return userService.createUser(usr);
    }
    
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> userOptional = userService.findUser(id);
    
        if (userOptional.isPresent()) {
            return ResponseEntity.ok(userOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @RequestMapping(value="/user", method=RequestMethod.GET)
    public List<User> readUSers(){
        return userService.getUsers();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}

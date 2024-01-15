package com.example.API_REST.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.API_REST.model.User;
import com.example.API_REST.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
        UserRepository userRepository;

        public User createUser(User user){
            return userRepository.save(user);
        }
}


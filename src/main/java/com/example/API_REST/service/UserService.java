package com.example.API_REST.service;

import java.util.List;
import java.util.Optional;

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

        public Optional<User> findUser(Long id) {
            return userRepository.findById(id);
        }

        public List<User> getUsers(){
            return userRepository.findAll();
        }

        public void deleteUser(Long id){
            userRepository.deleteById(id);
        }


}


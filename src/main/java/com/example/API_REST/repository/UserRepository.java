package com.example.API_REST.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.API_REST.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
}

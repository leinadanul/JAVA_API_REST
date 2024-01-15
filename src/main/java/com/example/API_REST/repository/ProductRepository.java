package com.example.API_REST.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.API_REST.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    
}

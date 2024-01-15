package com.example.API_REST.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.API_REST.model.Product;
import com.example.API_REST.repository.ProductRepository;

@Service
public class ProductService {


    @Autowired
    ProductRepository productRepository;

    public Product createProduct(Product product){
        return productRepository.save(product);
    }

    public Optional<Product> findProduct(Long id){
        return productRepository.findById(id);
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    } 

    public void deleteproduct(Long id){
        productRepository.deleteById(id);
    }
}

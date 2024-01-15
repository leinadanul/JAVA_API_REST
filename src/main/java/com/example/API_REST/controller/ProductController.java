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

import com.example.API_REST.model.Product;
import com.example.API_REST.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(value="/product", method=RequestMethod.POST)
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @RequestMapping(value="/product/{id}", method =RequestMethod.GET)
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Optional<Product> produOptional = productService.findProduct(id); 

        if (produOptional.isPresent()){
            return ResponseEntity.ok(produOptional.get());
        }else{
            return ResponseEntity.notFound().build();
        }

    }
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public List<Product> readProduct(){
        return productService.getProducts();
    }
    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    public void deleteproduct(@PathVariable Long id){
        productService.deleteproduct(id);
    }
}

package com.spring.market.web.controller;

import com.spring.market.domain.Product;
import com.spring.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController//indica que esta clase es el controlador de una API Rest
@RequestMapping("/products")//esta enotacion indica en que path estan las peticiones que se hacen
public class ProductController {
    //Lo primero es inyectar el servicio
    @Autowired//se puede implementar ya que el servicio tiene una anotacion de Spring
    private ProductService productService;

    public List<Product> getAll(){
        return productService.getAll();
    }
    public Optional<Product> getProduct(int productId){
        return productService.getProduct(productId);
    }
    public Optional<List<Product>>  getByCategory (int categoryId){
        return productService.getByCategory(categoryId);
    }
    public Product save(Product product){
        return productService.save(product);
    }
    public boolean delete(int productId){
        return productService.delete(productId);
    }
}

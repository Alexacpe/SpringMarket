package com.spring.market.web.controller;

import com.spring.market.domain.Product;
import com.spring.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController//indica que esta clase es el controlador de una API Rest
@RequestMapping("/products")//esta enotacion indica en que path estan las peticiones que se hacen
public class ProductController {
    //Lo primero es inyectar el servicio
    @Autowired//se puede implementar ya que el servicio tiene una anotacion de Spring
    private ProductService productService;

    @GetMapping("/all") //Para obtener informacion y se le indica el path sobre el que va a responder
    public List<Product> getAll(){
        return productService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable("id") int productId){//@PathVariable es para ingresar el id de la peticion
        return productService.getProduct(productId);
    }
    @GetMapping("/category/{categoryId}")
    public Optional<List<Product>>  getByCategory (@PathVariable("categoryId")int categoryId){
        return productService.getByCategory(categoryId);
    }
    @PostMapping("/save") //no se esta solicitando informacion, se le está enviando
    public Product save(@RequestBody Product product){ //RequestBody=Cuerpo de la peticion
        return productService.save(product);
    }
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id")int  productId){
        return productService.delete(productId);
    }
}

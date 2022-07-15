package com.spring.market.web.controller;

import com.spring.market.domain.Product;
import com.spring.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Product>> getAll(){//la clase ResponseEntity recibe en su cuerpo la lista en este caso de Product
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK) ; //nueva instancia de ResponseEntity con el metodo y el status de la peticion hhtp ok que significa que la peticion respondio de la manera adecuada
    }
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") int productId){//@PathVariable es para ingresar el id de la peticion
        return productService.getProduct(productId)
                .map(product -> new ResponseEntity<>(product,HttpStatus.OK))//como en su interior sigue esperando un Optional desde la clase, se transforma con un map
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));//cuando el producto no existe,deja de responder con null y envia el no found
    }
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getByCategory (@PathVariable("categoryId")int categoryId){
        return  productService.getByCategory(categoryId)
                .map(products -> new ResponseEntity<>(products,HttpStatus.OK))//como en su interior sigue esperando un Optional desde la clase, se transforma con un map
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));//cuando la categoria no existe,deja de responder con null y envia el no found
    }
    @PostMapping("/save") //no se esta solicitando informacion, se le esta enviando
    public ResponseEntity<Product> save(@RequestBody Product product){ //RequestBody=Cuerpo de la peticion
        return new ResponseEntity<>(productService.save(product),HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id")int  productId){//retorna un ResponseEntity
        //Validar si se pudo borrar o si el productId no existe
        if (productService.delete(productId)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);//deja de responder con null y envia el no found
        }
        }
    }


package com.spring.market.domain.service;

import com.spring.market.domain.Product;
import com.spring.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//El servicio desconoce lo que hay en el repositorio, esta trabajando en funcion del dominio.
@Service //tambien se puede declarar con @Component
public class ProductService {
    //inyecta la interface de ProductRepository para poder usar sus metodos
    @Autowired
    private ProductRepository productRepository;

    //Utilizar los metodos de productRepository
    //obtener la lista de productos
    public List<Product> getAll(){
        return productRepository.getAll();
    }
    //encontrar un producto
    public Optional<Product> getProduct(int productId){
        return productRepository.getProduct(productId);
    }
    //lista de productos por categoria
    public Optional<List<Product>> getByCategory(int categoryId){
        return productRepository.getByCategory(categoryId);
    }
    //guardar
    public Product save (Product product){
        return productRepository.save(product);
    }
    //borrar
    public boolean delete(int productId){
        //la funcion delete no retorna nada en el repositorio, pero se va a verificar si existe el producto que se va a eliminar
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }
}

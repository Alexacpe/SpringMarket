package com.spring.market.persistence;

import com.spring.market.persistence.crud.ProductoCrudRepository;
import com.spring.market.persistence.entity.Producto;

import java.util.List;

public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    //metodo que recupera la lista de todos los productos
    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }
}

package com.spring.market.persistence;

import com.spring.market.persistence.crud.ProductoCrudRepository;
import com.spring.market.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository//Es indicar que desde esta clase es desde donde se realizan las operaciones en la base de datos
public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;
        //Metodos para interactuar con la base de datos
    /**recupera la lista de todos los productos*/
    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }
    /**recuperar la lista de productos por categoria*/
    public List<Producto> getByCategoria(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    /**traer lista de productos escasos*/
    public Optional<List<Producto>> getEscasos(int cantidad) {
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad,true);
    }
    /**consultar un producto en particular*/
    public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto);//findByID:recuperar un elemento desde si PK
    }
    /**Guardar producto*/
    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }
    /**Eliminar el producto*/
    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}

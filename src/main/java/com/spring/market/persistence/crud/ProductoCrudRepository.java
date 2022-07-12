package com.spring.market.persistence.crud;

import com.spring.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

//Interface que interactua con Producto
public interface ProductoCrudRepository extends CrudRepository<Producto,Integer> {//crudrepository recibe la tabla y el tipo de dato de la clave primaria
        // QUERY METHODS: se realizan las consultas a la base de datos sin necesidad de ejecutar los query de SQL
    /**Recuperar la lista de productos que pertenecen a una categoria en orden ascendente por nombre*/
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);
    /**Traer la lista de los productos que se est�n agotando en stock que sean menor que*/
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock,boolean estado);

}

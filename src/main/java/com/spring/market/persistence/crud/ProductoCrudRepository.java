package com.spring.market.persistence.crud;

import com.spring.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

//Interface que interactua con Producto
public interface ProductoCrudRepository extends CrudRepository<Producto,Integer> {//crudrepository recibe la tabla y el tipo de dato de la clave primaria
}

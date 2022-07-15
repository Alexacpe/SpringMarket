package com.spring.market.domain.service.repository;
import com.spring.market.domain.Product;
import java.util.List;
import java.util.Optional;

/**Dar las reglas de comportamiento a todos los repositorios cuando se hable en terminos de producto,
asi intercatuar en base al dominio y no a los repositorios que van directo a las tablas de la base de datos.*/
public interface ProductRepository {
    //metodos que quiero que cualquier repositorios que vaya a trabajar con productos tenga que implementar
    /**Retornar una lista de todos los productos*/
    List<Product> getAll();
    /**
     *Retornar productos por categoria
     * @param categoryId:id de cada producto
     */
    Optional<List<Product>> getByCategory(int categoryId);

    /** Traer los productos que estan ecasos
     * @param quantity: asignar la cantidad que se considere para que el producto cuente como escaso
     * */
    Optional<List<Product>> getScarseProducts(int quantity);

    /**Retornar un producto especifico
     * @param productId: traer el producto por su id
     */
    Optional<Product> getProduct(int productId);
    /**Guardar producto
     * @param product: objeto de tipo product completo
     */
    Product save(Product product);

    void delete(int productId);
}

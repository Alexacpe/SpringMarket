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
    /**recupera la lista de todos los productos implementando findAll que es un metodo nativo de CrudRepository desde la interface
     * @return Devuelve la lista de productos
     */
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
    /**consultar un producto en particular
     * @param idProducto findByID:recuperar un elemento desde su PK
     * */
    public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto);
    }
    /**Guardar producto
     * @param producto recibe el producto completo
     * @return desde el metodo save del CrudRepository de spring data guarda el producto
     */
    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }
    /**Eliminar el producto: Con el metodo deleteById del CrudRepository de spring data elimina el producto desde el id que se le está ingresando como parametro
     * @param idProducto para identificar el producto que se va a eliminar
     */
    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}

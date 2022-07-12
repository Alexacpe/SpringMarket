package com.spring.market.persistence;

import com.spring.market.domain.Product;
import com.spring.market.domain.repository.ProductRepository;
import com.spring.market.persistence.crud.ProductoCrudRepository;
import com.spring.market.persistence.entity.Producto;
import com.spring.market.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
//Al utilizar los mappers el ProductoRepositorio queda enfocado al dominio y no a una tabla directamente
@Repository//Es indicar que desde esta clase es desde donde se realizan las operaciones en la base de datos
public class ProductoRepository implements ProductRepository { //implementar la interface
    private ProductoCrudRepository productoCrudRepository;
    //variable para hacer la conversión de product a producto
    private ProductMapper mapper;
        //Metodos para interactuar con la base de datos
    /**recupera la lista de todos los productos y los convierte en products gracias a los metodos del mapper
     * implementando findAll que es un metodo nativo de CrudRepository desde la interface
     * @return Devuelve la lista de products, tomando los productos y transformalos
     */
    @Override
    public List<Product> getAll(){
        List<Producto> productos =  (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos); //(List<Producto>) productoCrudRepository.findAll();
    }
    /**
     * Traer una lista de productos de una categoria  convertidos a products,la interface al esperar una lista de de optional y se est&aacute; devolviendo una lista normal     *
     * @return Optional.of -se utiliza el metodo of y se le pasa el mapper de productos
     */
    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }
    /**
     *Recupera la lista de productos de la base de datos y la convierte en products
     * @param quantity para asignar el valor que se va a considerar para que el product sea escaso
     * @return al no tener un mapeador que devuelva una lista de opcionales se le crea un map a los productos con una expresión lamda (arrow function)
     * para que el .map retorne un opcional de lo que se esté haciendo dentro de la expresión
     */
    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity,true);
        return productos.map(prods -> mapper.toProducts(prods));
    }
    /**Retornar un producto especifico
     * @return finById ya retorna un optional, lo unico que se debe hacer es pasar el producto por el mapper para convertirlo en un product     *
     */
    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }
    /**Guardar el producto
     * @param product del tipo Product
     * @return el save espera un producto y no un product por lo que se hace una conversión inversa
     */
    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    /**Eliminar el product: Con el metodo deleteById del CrudRepository de spring data elimina el product desde el id que se le está ingresando como parametro
     * @param productId para identificar el product que se va a eliminar
     */
    @Override
    public void delete(int productId){
        productoCrudRepository.deleteById(productId);
    }


    /* ya no se va a utilizar porque se van a orientar el repositorio a terminos del dominio
    /**recuperar la lista de productos por categoria
    public List<Producto> getByCategoria(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }*/
    /*
    /*
    traer lista de productos escasos
    public Optional<List<Producto>> getEscasos(int cantidad) {
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad,true);
    }
    /**consultar un producto en particular
     * @param idProducto findByID:recuperar un elemento desde su PK
     *
    public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto);
    }
    /**Guardar producto
     * @param producto recibe el producto completo
     * @return desde el metodo save del CrudRepository de spring data guarda el producto

    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }
    */
}

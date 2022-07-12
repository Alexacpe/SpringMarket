package com.spring.market.persistence.mapper;

import com.spring.market.domain.Product;
import com.spring.market.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;
//mapear los objetos de dominio en los entities
@Mapper(componentModel = "spring",uses = {CategoryMapper.class})//para implementar el mapper de catedory
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "idProducto", target = "productId"),//pide valor de fuente y valor a donde quiero llevarlo(donde la fuente sea idProdcuto llevarlo donde es productId)
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "precioVenta", target = "price"),
            @Mapping(source = "cantidadStock", target = "stock"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "categoria", target = "category"),//category tiene su propio mapper que necesita ser implementado
    })
    Product toProduct(Producto producto);
    List<Product> toProducts(List<Producto> productos);

    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto(Product product);
}


package com.spring.market.persistence.mapper;

import com.spring.market.domain.PurchaseItem;
import com.spring.market.persistence.entity.CompraProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
 /**Transforma los datos de compras producto a purchaseItem y de purchaseItem a compras producto*/
@Mapper(componentModel = "spring",uses = {ProductMapper.class})//indicar que se va a usar la clase ProductMapper
public interface PurchaseItemMapper {
    @Mappings({
            @Mapping(source = "id.idProducto",target = "productId"),
            @Mapping(source = "cantidad",target = "quantity"),
            @Mapping(source = "estado",target = "active")
    })
    PurchaseItem toPurchaseItem(CompraProducto producto);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "compra",ignore = true),
            @Mapping(target = "producto",ignore = true),
            @Mapping(target = "id.idCompra",ignore = true),
    })
    CompraProducto toPurchaseItem(PurchaseItem item);
}

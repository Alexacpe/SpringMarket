package com.spring.market.persistence.mapper;

import com.spring.market.domain.Category;
import com.spring.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

//mapear los objetos de dominio en los entities
@Mapper(componentModel = "spring")//agregar el componente de spring
public interface CategoryMapper {
    /**Retorna una conversion de categoria a category
     * @param categoria  Recibe una categoria para convertirla en category
     */
    @Mappings({//pide una lista de mappings
        @Mapping(source = "idCategoria",target ="categoryId"),//pide valor de fuente y valor a donde quiero llevarlo(donde la fuente sea idCategoria llevarlo donde es categoryId)
        @Mapping(source = "descripcion",target ="category"),
        @Mapping(source = "estado",target ="active")
    })
    Category toCategory(Categoria categoria);

    /**
     * Retornar la conversion de category a categoria
     */
    @InheritInverseConfiguration//indica que la conversion es la inversa que la enterior sin tener que declarar de nuevo todos los mappers
    @Mapping(target = "productos",ignore = true)//como no se va a mapear el campo productos en la categoria se indica que lo ignore
    Categoria toCategoria (Category category);


}

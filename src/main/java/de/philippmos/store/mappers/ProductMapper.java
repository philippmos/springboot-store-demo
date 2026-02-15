package de.philippmos.store.mappers;

import de.philippmos.store.dtos.ProductDto;
import de.philippmos.store.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "categoryId", source = "category.id")
    ProductDto toDto(Product product);
}

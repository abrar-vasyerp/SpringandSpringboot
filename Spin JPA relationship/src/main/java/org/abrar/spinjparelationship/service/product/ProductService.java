package org.abrar.spinjparelationship.service.product;

import org.abrar.spinjparelationship.dto.ProductRequestDto;
import org.abrar.spinjparelationship.dto.ProductResponseDto;


import java.util.List;

public interface ProductService {

    ProductResponseDto createProduct(ProductRequestDto dto);

    List<ProductResponseDto> getAllActiveProducts();

    ProductResponseDto getActiveProductById(Long productId);

    ProductResponseDto updateProduct(Long productId, ProductRequestDto dto);

    List<ProductResponseDto> searchProductsByName(String name);

    void softDeleteProduct(Long productId);

    List<ProductResponseDto> getProductsByFilter(
            String name,
            Double minPrice,
            Double maxPrice,
            int limit,
            int offset
    );
}


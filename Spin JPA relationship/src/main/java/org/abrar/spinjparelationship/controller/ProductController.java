package org.abrar.spinjparelationship.controller;


import lombok.RequiredArgsConstructor;
import org.abrar.spinjparelationship.dto.ApiResponse;
import org.abrar.spinjparelationship.entity.Product;
import org.abrar.spinjparelationship.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ApiResponse<Product>> createProduct(@RequestBody(required = false) Product product){
        Product saved=productService.createProduct(product);
        return ResponseEntity.ok(
                new ApiResponse<>(true,"Product Added",saved)
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Product>>> getAllProducts(){
        List<Product> productList=productService.getAllActiveProducts();
        return ResponseEntity.ok(
                new ApiResponse<>(true,"All Products",productList)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> getProductById(@PathVariable Long id){
        Product product=productService.getActiveProductById(id);
        return ResponseEntity.ok(
                new ApiResponse<>(true,"Product found",product)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Product>> updateProductById(@PathVariable Long id,@RequestBody(required = false) Product updateProduct){

        Product product=productService.updateProduct(id,updateProduct);
        return ResponseEntity.ok(
                new ApiResponse<>(true,"Updated successfully",product)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteProductById(@PathVariable Long id){
        productService.softDeleteProduct(id);

        return ResponseEntity.ok(
                new ApiResponse(true,"Product Deleted Successfully",null)
        );

    }
}

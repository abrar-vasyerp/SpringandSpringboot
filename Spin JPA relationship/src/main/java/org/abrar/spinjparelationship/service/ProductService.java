package org.abrar.spinjparelationship.service;

import lombok.RequiredArgsConstructor;
import org.abrar.spinjparelationship.entity.Product;
import org.abrar.spinjparelationship.repository.OrderItemRepository;
import org.abrar.spinjparelationship.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final OrderItemRepository orderItemRepository;
    private final ProductRepository productRepository;

    public Product createProduct(Product product) {
        if (product == null) {
            throw new RuntimeException("Product body is required");
        }
        product.setDeleted(false);
        if (product.getProductVariants() == null) {
            product.setProductVariants(new ArrayList<>());
        }
        return productRepository.save(product);
    }

    public List<Product> getAllActiveProducts() {
        return productRepository.findByIsDeletedFalse();
    }

    public List<Product> searchProductsByName(String name) {
        return productRepository
                .findByProductNameContainingIgnoreCaseAndIsDeletedFalse(name);
    }

    public void softDeleteProduct(Long productId) {

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId));

        if (product.isDeleted()) {
            throw new RuntimeException("Product already deleted");
        }
        int updated = productRepository.softDeleteProductByProductId(productId);

        if (updated == 0) {
            throw new RuntimeException("Product not found so can't deleted");
        }
    }

    public Product getActiveProductById(Long productId) {
        return productRepository
                .findByProductIdAndIsDeletedFalse(productId)
                .orElseThrow(() ->
                        new RuntimeException("Product not found with id: " + productId));
    }

    public Product updateProduct(Long productId,Product updateProduct){
        Product existing=getActiveProductById(productId);
        if (updateProduct == null) {
            throw new RuntimeException("Product body is required");
        }
        existing.setProductName(updateProduct.getProductName());
        existing.setTax(updateProduct.getTax());
        existing.setSellingPrice(updateProduct.getSellingPrice());

        return productRepository.save(existing);
    }


    public void printTopSellingProductsLastNDays(int n) {
        LocalDateTime nDaysAgo = LocalDateTime.now().minusDays(n);
        List<Object[]> topSell = orderItemRepository.findTopSellingProducts(nDaysAgo);

        for (Object[] row : topSell) {
            Product product = (Product) row[0];
            Double totalSold = (Double) row[1];
            System.out.println(product.getProductName()+" sold: "+totalSold);
        }
    }
}

package org.abrar.spinjparelationship.service;

import org.abrar.spinjparelationship.entity.Product;
import org.abrar.spinjparelationship.repository.OrderItemRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService {

    private OrderItemRepository orderItemRepository;

    public ProductService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
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

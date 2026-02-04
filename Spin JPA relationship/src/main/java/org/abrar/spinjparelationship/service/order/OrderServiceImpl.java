package org.abrar.spinjparelationship.service.order;

import lombok.RequiredArgsConstructor;
import org.abrar.spinjparelationship.dto.OrderItemRequestDto;
import org.abrar.spinjparelationship.dto.OrderRequestDto;
import org.abrar.spinjparelationship.entity.Order;
import org.abrar.spinjparelationship.entity.OrderItem;
import org.abrar.spinjparelationship.entity.ProductVariant;
import org.abrar.spinjparelationship.entity.StockMaster;
import org.abrar.spinjparelationship.repository.OrderRepository;
import org.abrar.spinjparelationship.repository.ProductVarientsRepository;
import org.abrar.spinjparelationship.repository.StockMasterRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final ProductVarientsRepository productVariantRepository;
    private final StockMasterRepository stockMasterRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Order createOrder(OrderRequestDto dto) {

        Order order = new Order();
        List<OrderItem> orderItems = new ArrayList<>();
        double totalAmount = 0;

        for (OrderItemRequestDto itemDto : dto.getOrderItems()) {

            ProductVariant variant = productVariantRepository.findById(itemDto.getProductVariantId())
                    .orElseThrow(() -> new RuntimeException("ProductVariant not found"));

            double availableStock = variant.getStockMasters().stream()
                    .mapToDouble(StockMaster::getQuantity)
                    .sum();

            if (availableStock < itemDto.getQuantity()) {
                throw new RuntimeException("Insufficient stock for variant: " + variant.getVariantName());
            }


            OrderItem orderItem = new OrderItem();
            orderItem.setProductVariant(variant);
            orderItem.setQuantity(itemDto.getQuantity());
            orderItem.setItemPrice(itemDto.getItemPrice());
            orderItem.setOrder(order);
            orderItems.add(orderItem);

            totalAmount += itemDto.getQuantity() * itemDto.getItemPrice();
        }

        order.setOrderItems(orderItems);
        order.setTotalAmount(totalAmount);


        Order savedOrder = orderRepository.save(order);

        for (OrderItem item : orderItems) {
            double remainingQty = item.getQuantity();
            List<StockMaster> batches = item.getProductVariant()
                    .getStockMasters()
                    .stream()
                    .sorted((b1, b2) -> b1.getExpiryDate().compareTo(b2.getExpiryDate()))
                    .toList();
            for (StockMaster batch : batches) {
                if (batch.getQuantity() >= remainingQty) {
                    batch.setQuantity(batch.getQuantity() - remainingQty);
                    stockMasterRepository.save(batch);
                    remainingQty = 0;
                    break;
                } else {
                    remainingQty -= batch.getQuantity();
                    batch.setQuantity(0);
                    stockMasterRepository.save(batch);
                }
            }


//            throw new RuntimeException("Simulated failure after order save");
        }

        return savedOrder;
    }
}

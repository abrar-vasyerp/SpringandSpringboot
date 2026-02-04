package org.abrar.spinjparelationship.service.order;

import org.abrar.spinjparelationship.dto.OrderRequestDto;
import org.abrar.spinjparelationship.entity.Order;
import org.springframework.transaction.annotation.Transactional;

public interface OrderService {
    @Transactional(rollbackFor = Exception.class)
    Order createOrder(OrderRequestDto dto);
}

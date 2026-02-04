package org.abrar.spinjparelationship.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.abrar.spinjparelationship.dto.ApiResponse;
import org.abrar.spinjparelationship.dto.OrderRequestDto;
import org.abrar.spinjparelationship.entity.Order;
import org.abrar.spinjparelationship.service.order.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<ApiResponse<Order>> createOrder(@Valid @RequestBody OrderRequestDto dto) {
        Order order = orderService.createOrder(dto);
        return ResponseEntity.ok(new ApiResponse<>(true, "Order created", order));
    }
}


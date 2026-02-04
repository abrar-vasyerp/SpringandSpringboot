package org.abrar.spinjparelationship.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequestDto {
    @NotNull(message = "Order items cannot be null")
    private List<OrderItemRequestDto> orderItems;
}

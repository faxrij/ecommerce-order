package com.example.ecommerceorder.model.response;

import com.example.ecommerceorder.entity.Order;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class OrderResponse {

    private Long id;

    private Long customerId;

    private Long productId;

    private String status;

    public static OrderResponse fromEntity(Order order) {
        return OrderResponse.builder()
                .id(order.getId())
                .customerId(order.getCustomerId())
                .productId(order.getProductId())
                .status(order.getStatus())
                .build();
    }
}

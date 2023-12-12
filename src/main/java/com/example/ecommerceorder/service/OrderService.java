package com.example.ecommerceorder.service;

import com.example.ecommerceorder.entity.Order;
import com.example.ecommerceorder.model.request.OrderRequest;
import com.example.ecommerceorder.model.response.OrderResponse;
import com.example.ecommerceorder.repository.read.OrderFollowerRepository;
import com.example.ecommerceorder.repository.write.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderFollowerRepository orderFollowerRepository;
    private final OrderRepository orderRepository;

    public List<OrderResponse> getOrders() {
        return orderFollowerRepository.findAll().stream().map(OrderResponse::fromEntity).collect(Collectors.toList());
    }

    public OrderResponse addOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setCustomerId(orderRequest.getCustomerId());
        order.setStatus(orderRequest.getStatus());
        order.setProductId(orderRequest.getProductId());
        orderRepository.save(order);
        return OrderResponse.fromEntity(order);
    }

    public OrderResponse getOrder(Long id) {
        return orderFollowerRepository.findById(id).map(OrderResponse::fromEntity).orElseThrow(() -> new RuntimeException("Error"));
    }
}

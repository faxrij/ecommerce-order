package com.example.ecommerceorder.controller;

import com.example.ecommerceorder.model.request.OrderRequest;
import com.example.ecommerceorder.model.response.OrderResponse;
import com.example.ecommerceorder.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<OrderResponse> getCustomers() {
        return orderService.getOrders();
    }

    @PostMapping
    public OrderResponse addCustomer(@RequestBody @Valid OrderRequest orderRequest) {
        return orderService.addOrder(orderRequest);
    }

    @GetMapping("/{id}")
    public OrderResponse getCustomers(@PathVariable Long id) {
        return orderService.getOrder(id);
    }
}

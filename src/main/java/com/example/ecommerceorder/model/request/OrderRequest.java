package com.example.ecommerceorder.model.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class OrderRequest {

    @NotEmpty
    private Long customerId;

    @NotEmpty
    private Long productId;

    @NotEmpty
    private String status;
}

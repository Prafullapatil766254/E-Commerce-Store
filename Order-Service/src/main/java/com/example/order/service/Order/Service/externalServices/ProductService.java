package com.example.order.service.Order.Service.externalServices;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "PRODUCT-SERVICE")
public interface ProductService {
}

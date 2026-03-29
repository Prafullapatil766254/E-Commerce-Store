package com.example.order.service.Order.Service.externalServices;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "USER-SERVICE")
public interface UserService {
}

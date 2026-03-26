package com.example.order.service.Order.Service.repository;

import com.example.order.service.Order.Service.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order , String> {
}

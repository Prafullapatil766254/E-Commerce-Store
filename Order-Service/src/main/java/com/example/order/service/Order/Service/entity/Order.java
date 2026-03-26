package com.example.order.service.Order.Service.entity;

import com.example.order.service.Order.Service.entity.enums.OrderStatus;
import com.example.order.service.Order.Service.entity.enums.PaymentMode;
import com.example.order.service.Order.Service.entity.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
@Document(collection = "orders")
public class Order {

    @Id
    private String id;

    private String userId;

    private List<Cart> items;

    private Long totalAmount;

    private OrderStatus status;

    private String paymentId;

    private PaymentMode paymentMode;

    private PaymentStatus paymentStatus;

    private Address shippingAddress;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}

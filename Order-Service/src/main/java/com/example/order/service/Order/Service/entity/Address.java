package com.example.order.service.Order.Service.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class Address {

    private String addressId;

    private String street;

    private String city;

    private String state;

    private String zipCode;

    private String country;
}

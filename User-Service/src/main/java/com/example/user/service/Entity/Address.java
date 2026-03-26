package com.example.user.service.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
@Entity(name = "addresses")
public class Address {

    @Id
    @GeneratedValue
    @org.hibernate.annotations.UuidGenerator
    private UUID id;

    private String street;

    private String city;

    private String state;

    private String zipCode;

    private String country;

    // Many addresses belong to one user
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

package com.example.product.service.controller;

import com.example.product.service.endpoints.ApiEndpoints;
import com.example.product.service.exceptions.custom.ValidationException;
import com.example.product.service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "Product Staff Controller", path = ApiEndpoints.PRODUCT_STAFF_URL)
public class ProductStaffController {

    @Autowired
    private ProductService productService;

//    @GetMapping(path = "/get")
//    public ResponseEntity<String> addProduct(){
//        throw new ValidationException("Something went wrong!" , 102);
//    }
}

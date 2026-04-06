package com.example.product.service.utils;

import com.example.product.service.entity.enums.ErrorResponse;
import com.example.product.service.entity.request.ProductRequest;
import com.example.product.service.exceptions.custom.ValidationException;
import org.springframework.util.StringUtils;

/**
 * @author Prafull_Patil
 * Class for validating product requests
 */
public class ProductValidator {

    public static void validateCreateProductRequest(ProductRequest productRequest) {

        if(!StringUtils.hasLength(productRequest.getName())){
            throw new ValidationException("'name' can not be null!" , ErrorResponse.VALIDATION_ERROR);
        }

        if(!StringUtils.hasLength(productRequest.getDescription())){
            throw new ValidationException("'description' can not be null!" , ErrorResponse.VALIDATION_ERROR);
        }

        if(productRequest.getPrice() == null){
            throw new ValidationException("'price' can not be null!" , ErrorResponse.VALIDATION_ERROR);
        }

        if(productRequest.getCategory() == null){
            throw new ValidationException("'category' can not be null!" , ErrorResponse.VALIDATION_ERROR);
        }
    }

    public static void validateUpdateProductRequest(ProductRequest productRequest) {
        if(!StringUtils.hasLength(productRequest.getId())){
            throw new ValidationException("'id' can not be null!" , ErrorResponse.VALIDATION_ERROR);
        }
    }

    public static void validateDeleteProductRequest(String productId) {
        if(!StringUtils.hasLength(productId)){
            throw new ValidationException("'productId' can not be null!" , ErrorResponse.VALIDATION_ERROR);
        }
    }
}

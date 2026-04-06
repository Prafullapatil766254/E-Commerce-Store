package com.example.product.service.entity.request;

import com.example.product.service.entity.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * @author Prafull_Patil
 * Request Pojo For {@link com.example.product.service.entity.Product}
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class ProductRequest {

    private String id;

    private String name;

    private String description;

    private Double price;

    private Integer stock;

    private String brand;

    private Category category;

    private List<String> imageUrls;
}

package com.example.product.service.entity.response;

import com.example.product.service.entity.Product;
import com.example.product.service.entity.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

/**
 * @author Prafull_Patil
 * Response Pojo For {@link com.example.product.service.entity.Product}
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class ProductResponse {

    private String id;

    private String name;

    private String description;

    private Double price;

    private Integer stock;

    private String brand;

    private Category category;

    private List<String> imageUrls;

    private Boolean isAvailable;


    /**
     * Method to build {@link ProductResponse} from {@link Product}
     *
     * @param product {@link Product}
     * @return {@link ProductResponse}
     */
    public static ProductResponse buildProductResponse(Product product) {
        if (product == null) {
            return null;
        }
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .stock(product.getStock())
                .brand(product.getBrand())
                .category(product.getCategory())
                .imageUrls(product.getImageUrls())
                .isAvailable(product.getIsAvailable())
                .build();
    }
}

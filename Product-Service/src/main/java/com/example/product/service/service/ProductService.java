package com.example.product.service.service;

import com.example.product.service.entity.Product;
import com.example.product.service.entity.enums.Category;
import com.example.product.service.entity.enums.ErrorResponse;
import com.example.product.service.entity.request.ProductRequest;
import com.example.product.service.entity.response.ProductResponse;
import com.example.product.service.exceptions.custom.ValidationException;
import com.example.product.service.repository.ProductRepository;
import com.example.product.service.utils.ProductValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService {

    private static final Logger LOG = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;

    /// //////////////////////////////////////////////////////////////////////////////

    /**
     * Method to create product - Admin
     *
     * @param productRequest {@link ProductRequest}
     * @return {@link Product}
     */
    public Product createProduct(ProductRequest productRequest){

        try {

            // Validate create product request
            ProductValidator.validateCreateProductRequest(productRequest);

            // Set 'isAvailable' based on product stock
            boolean isAvailable = productRequest.getStock() != null && productRequest.getStock() > 0;

            // Return the response
            return productRepository.save(Product.builder()
                    .name(productRequest.getName())
                    .description(productRequest.getDescription())
                    .price(productRequest.getPrice())
                    .stock(productRequest.getStock())
                    .brand(productRequest.getBrand())
                    .category(productRequest.getCategory())
                    .imageUrls(productRequest.getImageUrls())
                    .build());

        } catch (ValidationException validationException) {
            throw validationException;
        } catch (Exception exception) {
            LOG.info("Something went wrong inside 'createProduct'!! {} ", exception.getMessage());
            throw new ValidationException("Something went wrong! Please contact administrator!", ErrorResponse.UNPROCESSABLE_ENTITY);
        }
    }

    /**
     * Method to update product - Admin
     *
     * @param productRequest {@link ProductRequest}
     * @return {@link Product}
     */
    public Product updateProduct(ProductRequest productRequest){

        try {

            // Validate create product request
            ProductValidator.validateUpdateProductRequest(productRequest);

            // Get product
            Product product = productRepository.findById(productRequest.getId()).orElse(null);
            if(product == null){
                throw new ValidationException("Can't found product with given 'id'!", ErrorResponse.VALIDATION_ERROR);
            }

            // Proceed for update
            String name = (StringUtils.hasLength(productRequest.getName())) ? productRequest.getName() : product.getName();

            String description = (StringUtils.hasLength(productRequest.getDescription())) ? productRequest.getDescription() : product.getDescription();

            Double price = (productRequest.getPrice() != null) ? productRequest.getPrice() : product.getPrice();

            Integer stock = (productRequest.getStock() != null) ? productRequest.getStock() : product.getStock();

            String brand = (StringUtils.hasLength(productRequest.getBrand())) ? productRequest.getBrand() : product.getBrand();

            Category category = (productRequest.getCategory() != null) ? productRequest.getCategory() : product.getCategory();

            List<String> imageUrl = (productRequest.getImageUrls() != null && !productRequest.getImageUrls().isEmpty()) ? productRequest.getImageUrls() : product.getImageUrls();

            // Set 'isAvailable' based on product stock
            boolean isAvailable = stock > 0;

            // Return the response
            return productRepository.save(product.toBuilder()
                    .name(productRequest.getName())
                    .description(productRequest.getDescription())
                    .price(productRequest.getPrice())
                    .stock(productRequest.getStock())
                    .brand(productRequest.getBrand())
                    .category(productRequest.getCategory())
                    .imageUrls(productRequest.getImageUrls())
                    .updatedAt(LocalDateTime.now())
                    .build());

        } catch (ValidationException validationException) {
            throw validationException;
        } catch (Exception exception) {
            LOG.info("Something went wrong inside 'updateProduct'!! {} " , exception.getMessage());
            throw new ValidationException("Something went wrong! Please contact administrator!" , ErrorResponse.UNPROCESSABLE_ENTITY);
        }
    }

    /**
     * Method to delete product - Admin
     *
     * @param productId {@link String}
     * @return {@link Product}
     */
    public Product deleteProductById(String productId){

        try {

            // Validate create product request
            ProductValidator.validateDeleteProductRequest(productId);

            // Get product
            Product productToBeDeleted = productRepository.findById(productId).orElse(null);
            if(productToBeDeleted == null){
                throw new ValidationException("Can't found product with given 'productId'!", ErrorResponse.VALIDATION_ERROR);
            }

            // Delete product
            productRepository.delete(productToBeDeleted);

            // Return deleted product
            return productToBeDeleted;

        } catch (ValidationException validationException) {
            throw validationException;
        } catch (Exception exception) {
            LOG.info("Something went wrong inside 'deleteProductById'!! {} ", exception.getMessage());
            throw new ValidationException("Something went wrong! Please contact administrator!", ErrorResponse.UNPROCESSABLE_ENTITY);
        }
    }

    /**
     * Method to get product by id - Admin
     *
     * @param productId {@link String}
     * @return {@link Product}
     */
    public Product getProductById(String productId){

        try {

            // Validate create product request
            ProductValidator.validateDeleteProductRequest(productId);

            // Get product
            Product product = productRepository.findById(productId).orElse(null);
            if(product == null){
                throw new ValidationException("Can't found product with given 'productId'!", ErrorResponse.VALIDATION_ERROR);
            }

            // Return deleted product
            return product;

        } catch (ValidationException validationException) {
            throw validationException;
        } catch (Exception exception) {
            LOG.info("Something went wrong inside 'getProductById'!! {} ", exception.getMessage());
            throw new ValidationException("Something went wrong! Please contact administrator!", ErrorResponse.UNPROCESSABLE_ENTITY);
        }
    }

    /**
     * Method to get all products - Admin
     *
     * @param pageable {@link Pageable}
     * @return {@link List<Product>}
     */
    public List<Product> getAllProducts(Pageable pageable){

        try {
            // Return all products
            return productRepository.findAll(pageable).toList();

        } catch (ValidationException validationException) {
            throw validationException;
        } catch (Exception exception) {
            LOG.info("Something went wrong inside 'getAllProducts'!! {} ", exception.getMessage());
            throw new ValidationException("Something went wrong! Please contact administrator!", ErrorResponse.UNPROCESSABLE_ENTITY);
        }
    }

    //////////////////////////////// CONSUMER APIS ///////////////////////////////////////

    /**
     * Method to get product by id - Consumer
     *
     * @param productId {@link String}
     * @return {@link ProductResponse}
     */
    public ProductResponse getProductByIdConsumer(String productId){

        try {

            // Validate create product request
            ProductValidator.validateDeleteProductRequest(productId);

            // Get product
            Product product = productRepository.findById(productId).orElse(null);

            if(product == null){
                throw new ValidationException("Can't found product with given 'productId'!", ErrorResponse.VALIDATION_ERROR);
            }

            // Return deleted product
            return ProductResponse.buildProductResponse(product);

        } catch (ValidationException validationException) {
            throw validationException;
        } catch (Exception exception) {
            LOG.info("Something went wrong inside 'getProductByIdConsumer'!! {} ", exception.getMessage());
            throw new ValidationException("Something went wrong! Please contact administrator!", ErrorResponse.UNPROCESSABLE_ENTITY);
        }
    }

    /**
     * Method to get all products - Consumer
     *
     * @param pageable {@link Pageable}
     * @return {@link List<ProductResponse>}
     */
    public List<ProductResponse> getAllProductsConsumer(Pageable pageable){

        try {
            // Return all products
            List<Product> products = productRepository.findAll(pageable).toList();

            return products.stream()
                    .map(ProductResponse::buildProductResponse)
                    .toList();

        } catch (ValidationException validationException) {
            throw validationException;
        } catch (Exception exception) {
            LOG.info("Something went wrong inside 'getAllProductsConsumer'!! {} ", exception.getMessage());
            throw new ValidationException("Something went wrong! Please contact administrator!", ErrorResponse.UNPROCESSABLE_ENTITY);
        }
    }

}

package com.spring.desafio.controller.dto;


import com.spring.desafio.entity.Product;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * {@link Product} DTO format
 */
@Getter
public class ProductResponseDTO {
    /**
     * Product name
     */
    private String name;
    /**
     * Product category
     */
    private String category;
    /**
     * Product brand
     */
    private String brand;
    /**
     * Product price
     */
    private BigDecimal price;
    /**
     * Product quantity available
     */
    private Integer quantity;
    /**
     * Whether product offers free shipping or not
     */
    private Boolean freeShipping;
    /**
     * Product review evaluation
     */
    private String prestige;

    ProductResponseDTO(Product product) {
        this.name = product.getName();
        this.quantity = product.getQuantity();
        this.quantity = product.getQuantity();
        this.category = product.getCategory();
        this.freeShipping = product.getFreeShipping();
        this.prestige = product.getPrestige();
        this.price = product.getPrice();
        this.brand = product.getBrand();
    }

    /**
     * Parses a {@link List< Product >} to {@link List< ProductResponseDTO >}
     *
     * @param productList list of product to be parsed
     * @return a product DTO list
     */
    public static List<ProductResponseDTO> toDtoList(List<Product> productList) {
        List<ProductResponseDTO> productResponseDTOList = new ArrayList<>();
        productList.forEach(p -> productResponseDTOList.add(new ProductResponseDTO(p)));
        return productResponseDTOList;
    }

}

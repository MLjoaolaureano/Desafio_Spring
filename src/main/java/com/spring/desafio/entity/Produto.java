package com.spring.desafio.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * The main product entity.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
    /**
     * Product id
     */
    private Long productId;
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

}

package com.spring.desafio.entity;

import lombok.Data;

/**
 * This entity represents a request for a single purchase item made from user
 */
@Data
public class RequestPurchase {
    /**
     * The product id to be bought
     */
    Long productId;
    /**
     * The product quantity to be bought
     */
    Integer quantity;
}

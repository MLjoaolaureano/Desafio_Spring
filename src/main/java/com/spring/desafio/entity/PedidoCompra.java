package com.spring.desafio.entity;

import lombok.Data;
import lombok.Getter;

/**
 * This entity represents a request for a single purchase item made from user
 */
@Data
public class PedidoCompra {
    /**
     * The product id to be bought
     */
    Long productId;
    /**
     * The product quantity to be bought
     */
    Integer quantity;
}

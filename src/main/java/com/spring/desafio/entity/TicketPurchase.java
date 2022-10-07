package com.spring.desafio.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * This class represents a list of products bought by user.
 */
@Data
public class TicketPurchase {

    static Integer _id = 0;
    /**
     * The list of product successfully purchased
     */
    List<Product> productList;
    /**
     * The final price of purchase
     */
    BigDecimal valorTotal;
    /**
     * Ticket ID
     */
    private Integer id;

    public TicketPurchase(List<Product> productList, BigDecimal valorTotal) {
        this.productList = productList;
        this.valorTotal = valorTotal;
        this.id = ++_id;
    }
}

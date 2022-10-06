package com.spring.desafio.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * This class represents a list of products bought by user.
 */
@Data
public class TicketCompra {

    static Integer _id = 0;
    /**
     * The list of product successfully purchased
     */
    List<Produto> produtoList;
    /**
     * The final price of purchase
     */
    BigDecimal valorTotal;
    /**
     * Ticket ID
     */
    private Integer id;

    public TicketCompra(List<Produto> produtoList, BigDecimal valorTotal) {
        this.produtoList = produtoList;
        this.valorTotal = valorTotal;
        this.id = ++_id;
    }
}

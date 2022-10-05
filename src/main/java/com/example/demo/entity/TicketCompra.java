package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Data
public class TicketCompra {

    static Integer _id = 0;
    private Integer id;
    List<Produto> produtoList;
    BigDecimal valorTotal;

    public TicketCompra(List<Produto> produtoList, BigDecimal valorTotal){
        this.produtoList = produtoList;
        this.valorTotal = valorTotal;
        this.id = ++_id;
    }
}

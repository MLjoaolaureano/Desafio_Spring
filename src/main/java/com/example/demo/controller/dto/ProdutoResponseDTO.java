package com.example.demo.controller.dto;


import com.example.demo.entity.Produto;

public class ProdutoResponseDTO {

    private Long productId;
    private String name;
    private Integer quantity;

    ProdutoResponseDTO(Produto produto) {
        this.productId = produto.getProductId();
        this.name = produto.getName();
        this.quantity = produto.getQuantity();
    }

}

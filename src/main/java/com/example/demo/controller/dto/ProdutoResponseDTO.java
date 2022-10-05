package com.example.demo.controller.dto;


import com.example.demo.entity.Produto;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ProdutoResponseDTO {

    private Long productId;
    private String name;
    private Integer quantity;

    ProdutoResponseDTO(Produto produto) {
        this.productId = produto.getProductId();
        this.name = produto.getName();
        this.quantity = produto.getQuantity();
    }

    public static List<ProdutoResponseDTO> toDtoList (List<Produto> produtoList) {
        List<ProdutoResponseDTO> produtoResponseDTOList = new ArrayList<>();
        produtoList.forEach(p -> produtoResponseDTOList.add(new ProdutoResponseDTO(p)));
        return produtoResponseDTOList;
    }

}

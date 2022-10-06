package com.spring.desafio.controller.dto;


import com.spring.desafio.entity.Cliente;
import com.spring.desafio.entity.Produto;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link Produto} DTO format
 */
@Getter
public class ProdutoResponseDTO {

    /**
     * Product ID
     */
    private Long productId;
    /**
     * Product Name
     */
    private String name;
    /**
     * Product quantity available
     */
    private Integer quantity;

    ProdutoResponseDTO(Produto produto) {
        this.productId = produto.getProductId();
        this.name = produto.getName();
        this.quantity = produto.getQuantity();
    }

    /**
     * Parses a {@link List<Produto>} to {@link List<ProdutoResponseDTO>}
     *
     * @param produtoList list of product to be parsed
     * @return a product DTO list
     */
    public static List<ProdutoResponseDTO> toDtoList(List<Produto> produtoList) {
        List<ProdutoResponseDTO> produtoResponseDTOList = new ArrayList<>();
        produtoList.forEach(p -> produtoResponseDTOList.add(new ProdutoResponseDTO(p)));
        return produtoResponseDTOList;
    }

}

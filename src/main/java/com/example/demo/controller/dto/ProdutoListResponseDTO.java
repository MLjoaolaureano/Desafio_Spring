package com.example.demo.controller.dto;

import com.example.demo.entity.Produto;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ProdutoListResponseDTO {

    private List<ProdutoResponseDTO> produtoResponseDTOList = new ArrayList<>();

    public ProdutoListResponseDTO(List<Produto> produtoList) {
        produtoList.forEach(p -> this.produtoResponseDTOList.add(new ProdutoResponseDTO(p)));

    }

}

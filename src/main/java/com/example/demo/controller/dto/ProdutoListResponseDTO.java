package com.example.demo.controller.dto;

import com.example.demo.entity.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoListResponseDTO {

    private List<ProdutoResponseDTO> produtoResponseDTOList = new ArrayList<>();

    public ProdutoListResponseDTO(List<Produto> produtoList) {
        produtoList.forEach(p -> produtoResponseDTOList.add(new ProdutoResponseDTO(p)));

    }

}

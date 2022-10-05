package com.spring.desafio.service;

import com.spring.desafio.controller.dto.ProdutoResponseDTO;
import com.spring.desafio.entity.Produto;
import com.spring.desafio.exception.FileNotFoundException;

import java.util.List;

public interface IProdutoService {

    List<ProdutoResponseDTO> getAll() throws FileNotFoundException;
    List<ProdutoResponseDTO> saveAll(List<Produto> produtoList) throws Exception;
    List<ProdutoResponseDTO> getCategoryFreeShipping(String category, Boolean freeShipping, Integer order) throws Exception;
    List<ProdutoResponseDTO> getByCategory(String category) throws Exception;
    List<ProdutoResponseDTO> getFreeShippingPrestige(Boolean freeShipping, String prestige) throws Exception;

}

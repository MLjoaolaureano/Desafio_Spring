package com.spring.desafio.service;

import com.spring.desafio.controller.dto.ProductResponseDTO;
import com.spring.desafio.entity.Product;
import com.spring.desafio.exception.FileNotFoundException;

import java.util.List;

public interface IProductService {

    List<ProductResponseDTO> getAll() throws FileNotFoundException;

    List<ProductResponseDTO> saveAll(List<Product> productList) throws Exception;

    List<ProductResponseDTO> getCategoryFreeShipping(String category, Boolean freeShipping, Integer order) throws Exception;

    List<ProductResponseDTO> getByCategory(String category) throws Exception;

    List<ProductResponseDTO> getFreeShippingPrestige(Boolean freeShipping, String prestige) throws Exception;

}

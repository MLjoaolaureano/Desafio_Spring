package com.example.demo.service;

import com.example.demo.entity.Produto;
import com.example.demo.exception.FileNotFoundException;

import java.io.IOException;
import java.util.List;

public interface IProdutoService {

    List<Produto> getAll() throws FileNotFoundException;
    List<Produto> saveAll(List<Produto> produtoList) throws Exception;
    public List<Produto> getCategoryFreeShipping(String category, Boolean freeShipping, Integer order) throws Exception;

    List<Produto> getByCategory(String category) throws Exception;
}

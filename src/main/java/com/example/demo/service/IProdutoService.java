package com.example.demo.service;

import com.example.demo.entity.Produto;

import java.util.List;

public interface IProdutoService {

    public List<Produto> getAll();
    public List<Produto> getCategoryFreeShipping(String category, Boolean freeShipping);
}

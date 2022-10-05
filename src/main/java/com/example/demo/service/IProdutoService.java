package com.example.demo.service;

import com.example.demo.entity.Produto;

import java.io.IOException;
import java.util.List;

public interface IProdutoService {

    List<Produto> getAll() throws IOException;

    List<Produto> saveAll(List<Produto> produtoList) throws Exception;
}

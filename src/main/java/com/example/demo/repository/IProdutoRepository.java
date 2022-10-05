package com.example.demo.repository;

import com.example.demo.entity.Produto;
import com.example.demo.exception.FileNotFoundException;
import com.example.demo.exception.ProdutoNotExistsException;

import java.io.IOException;
import java.util.List;

public interface IProdutoRepository {

    List<Produto> getAll() throws FileNotFoundException;

    List<Produto> saveAll(List<Produto> produtoList) throws Exception;

    Produto getProdutoById(Long id) throws FileNotFoundException, ProdutoNotExistsException;

}

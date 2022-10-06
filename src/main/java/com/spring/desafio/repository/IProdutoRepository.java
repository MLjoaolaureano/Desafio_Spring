package com.spring.desafio.repository;

import com.spring.desafio.entity.PedidoCompra;
import com.spring.desafio.entity.Produto;
import com.spring.desafio.exception.FileNotFoundException;
import com.spring.desafio.exception.ProdutoNotExistsException;

import java.util.List;

public interface IProdutoRepository {

    List<Produto> getAll() throws FileNotFoundException;

    List<Produto> saveAll(List<Produto> produtoList) throws Exception;

    Produto getProdutoById(Long id) throws FileNotFoundException, ProdutoNotExistsException;

    void atualizaEstoque(List<PedidoCompra> pedidoCompraList) throws FileNotFoundException;

}

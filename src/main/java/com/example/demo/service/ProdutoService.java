package com.example.demo.service;


import com.example.demo.entity.Produto;
import com.example.demo.repository.IProdutoRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ProdutoService implements IProdutoService {


    private final IProdutoRepository produtoRepository;

    public ProdutoService(IProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> getAll() throws IOException {
        return this.produtoRepository.getAll();
    }

    @Override
    public List<Produto> saveAll(List<Produto> produtoList) throws Exception {
        return this.produtoRepository.saveAll(produtoList);
    }

}

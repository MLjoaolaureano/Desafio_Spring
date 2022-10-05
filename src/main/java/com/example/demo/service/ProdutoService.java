package com.example.demo.service;


import com.example.demo.entity.Produto;
import com.example.demo.repository.IProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {


    private final IProdutoRepository produtoRepository;

    public ProdutoService(IProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }


    public List<Produto> getAll(){
        return this.produtoRepository.getAll();
    }

}

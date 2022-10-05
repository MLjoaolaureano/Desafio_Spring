package com.example.demo.service;


import com.example.demo.entity.Produto;
import com.example.demo.repository.IProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService implements IProdutoService {


    private final IProdutoRepository produtoRepository;

    public ProdutoService(IProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }


    public List<Produto> getAll(){
        return this.produtoRepository.getAll();
    }

    public List<Produto> getByCategory(String category) {
        return this.produtoRepository.getAll().stream()
                .filter(p -> p.getCategory().equals(category))
                .toList();
    }
}

package com.example.demo.service;

import com.example.demo.entity.Produto;
import com.example.demo.exception.FileNotFoundException;
import com.example.demo.repository.IProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService implements IProdutoService {


    private final IProdutoRepository produtoRepository;

    public ProdutoService(IProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> getAll() throws FileNotFoundException {
        return this.produtoRepository.getAll();
    }

    @Override
    public List<Produto> saveAll(List<Produto> produtoList) throws Exception {
        return this.produtoRepository.saveAll(produtoList);

    }
    @Override
    public List<Produto> getCategoryFreeShipping(String category, Boolean freeShipping) throws Exception{
        return this.produtoRepository.getAll().stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category) && p.getFreeShipping() == freeShipping)
                .collect(Collectors.toList());
    }

    public List<Produto> getByCategory(String category) throws FileNotFoundException {
        return this.produtoRepository.getAll()
                .stream()
                .filter(p -> p.getCategory().equals(category)).toList();
    }
}

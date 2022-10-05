package com.example.demo.service;

import com.example.demo.entity.Produto;
import com.example.demo.exception.FileNotFoundException;
import com.example.demo.repository.IProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
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
    public List<Produto> getCategoryFreeShipping(String category, Boolean freeShipping, Integer order) throws Exception{
        List<Produto> lista = this.produtoRepository.getAll().stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category) && p.getFreeShipping() == freeShipping)
                .collect(Collectors.toList());
        if(order == null) return lista;

        switch (order) {
            case 0:
                lista = lista.stream()
                        .sorted(Comparator.comparing(Produto::getName))
                        .collect(Collectors.toList());
                break;
            case 1:
                lista = lista.stream()
                        .sorted(Comparator.comparing(Produto::getName).reversed())
                        .collect(Collectors.toList());
                break;
            case 2:
                lista = lista.stream()
                        .sorted(Comparator.comparing(Produto::getPrice).reversed())
                        .collect(Collectors.toList());
                break;
            case 3:
                lista = lista.stream()
                        .sorted(Comparator.comparing(Produto::getPrice))
                        .collect(Collectors.toList());
                break;
        }
        return lista;
    }


    public List<Produto> getByCategory(String category) throws FileNotFoundException {
        return this.produtoRepository.getAll()
                .stream()
                .filter(p -> p.getCategory().equals(category)).toList();
    }

    @Override
    public List<Produto> getFreeShippingPrestige(Boolean freeShipping, String prestige) throws Exception {
        return null;
    }
}

package com.spring.desafio.service;

import com.spring.desafio.controller.dto.ProdutoResponseDTO;
import com.spring.desafio.entity.Produto;
import com.spring.desafio.exception.FileNotFoundException;
import com.spring.desafio.repository.IProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoService implements IProdutoService {

    private final IProdutoRepository produtoRepository;

    public ProdutoService(IProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<ProdutoResponseDTO> getAll() throws FileNotFoundException {
        return ProdutoResponseDTO.toDtoList(this.produtoRepository.getAll());
    }

    @Override
    public List<ProdutoResponseDTO> saveAll(List<Produto> produtoList) throws Exception {
        return ProdutoResponseDTO.toDtoList(this.produtoRepository.saveAll(produtoList));

    }

    @Override
    public List<ProdutoResponseDTO> getCategoryFreeShipping(String category, Boolean freeShipping, Integer order) throws Exception {
        List<Produto> lista = this.produtoRepository.getAll().stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category) && p.getFreeShipping() == freeShipping)
                .collect(Collectors.toList());
        if (order == null) return ProdutoResponseDTO.toDtoList(lista);

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
        return ProdutoResponseDTO.toDtoList(lista);
    }


    public List<ProdutoResponseDTO> getByCategory(String category) throws FileNotFoundException {
        return ProdutoResponseDTO.toDtoList(this.produtoRepository.getAll()
                .stream()
                .filter(p -> p.getCategory().equals(category)).toList());
    }

    @Override
    public List<ProdutoResponseDTO> getFreeShippingPrestige(Boolean freeShipping, String prestige) throws Exception {

        return ProdutoResponseDTO.toDtoList(this.produtoRepository.getAll().stream()
                .filter(p -> p.getFreeShipping() == freeShipping && p.getPrestige().length() >= prestige.length())
                .collect(Collectors.toList()));
    }
}

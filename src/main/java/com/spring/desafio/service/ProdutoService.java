package com.spring.desafio.service;

import com.spring.desafio.controller.dto.ProdutoResponseDTO;
import com.spring.desafio.entity.Produto;
import com.spring.desafio.exception.FileNotFoundException;
import com.spring.desafio.repository.IProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * ProdutoService is the Service bean for {@link com.spring.desafio.entity.Produto} entity.
 *
 */
@Service
public class ProdutoService implements IProdutoService {

    private final IProdutoRepository produtoRepository;

    public ProdutoService(IProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    /**
     * Get all at storage
     * @return list of ProdutoResponseDTO
     * @throws FileNotFoundException
     */
    public List<ProdutoResponseDTO> getAll() throws FileNotFoundException {
        return ProdutoResponseDTO.toDtoList(this.produtoRepository.getAll());
    }

    /**
     * Save a list of product at storage
     * @param produtoList list of product
     * @return list of ProdutoResponseDTO
     * @throws Exception
     */
    @Override
    public List<ProdutoResponseDTO> saveAll(List<Produto> produtoList) throws Exception {
        return ProdutoResponseDTO.toDtoList(this.produtoRepository.saveAll(produtoList));

    }

    /**
     * Returns a list of all products based in Category value and Freeshipping
     * @param category category type
     * @param freeShipping whether product offers freeShiping or not.
     * @param order this value indicates the order method to be applied.
     *              In case value is 0, it will sort by product name from A to Z
     *              In case value is 1, it will sort by product name from Z to A
     *              In case value is 2, it will sort by product price from biggest to smallest
     *              In case value is 3, it will sort by product price from smallest to biggest
     * @return list of ProdutoResponseDTO
     * @throws Exception
     */
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

    /**
     * Returns a list of all products based in category value
     * @param category category type
     * @return list of ProdutoResponseDTO
     * @throws FileNotFoundException
     */
    public List<ProdutoResponseDTO> getByCategory(String category) throws FileNotFoundException {
        return ProdutoResponseDTO.toDtoList(this.produtoRepository.getAll()
                .stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category)).toList());
    }

    /**
     * Returns a list with products given filter for freeShipping and prestige
     * @param freeShipping whether product offers freeShiping or not.
     * @param prestige amount of prestige that the product must have at least.
     * @return list of ProdutoResponseDTO
     * @throws Exception
     */
    @Override
    public List<ProdutoResponseDTO> getFreeShippingPrestige(Boolean freeShipping, String prestige) throws Exception {

        return ProdutoResponseDTO.toDtoList(this.produtoRepository.getAll().stream()
                .filter(p -> p.getFreeShipping() == freeShipping && p.getPrestige().length() >= prestige.length())
                .collect(Collectors.toList()));
    }
}

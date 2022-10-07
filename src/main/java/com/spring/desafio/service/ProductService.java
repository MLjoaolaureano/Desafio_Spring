package com.spring.desafio.service;

import com.spring.desafio.controller.dto.ProductResponseDTO;
import com.spring.desafio.entity.Product;
import com.spring.desafio.exception.FileNotFoundException;
import com.spring.desafio.repository.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ProdutoService is the Service bean for {@link Product} entity.
 */
@Service
public class ProductService implements IProductService {

    private final IProductRepository produtoRepository;

    public ProductService(IProductRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    /**
     * Get all at storage
     *
     * @return list of product DTO
     * @throws FileNotFoundException
     */
    public List<ProductResponseDTO> getAll() throws FileNotFoundException {
        return ProductResponseDTO.toDtoList(this.produtoRepository.getAll());
    }

    /**
     * Save a list of product at storage
     *
     * @param productList list of product
     * @return list of product DTO
     * @throws Exception
     */
    @Override
    public List<ProductResponseDTO> saveAll(List<Product> productList) throws Exception {
        return ProductResponseDTO.toDtoList(this.produtoRepository.saveAll(productList));

    }

    /**
     * Returns {@link List< ProductResponseDTO >} filtered by Category value and FreeShipping
     *
     * @param category     category type
     * @param freeShipping whether product offers freeShipping or not.
     * @param order        this value indicates the order method to be applied.
     *                     In case value is 0, it will sort by product name from A to Z
     *                     In case value is 1, it will sort by product name from Z to A
     *                     In case value is 2, it will sort by product price from biggest to smallest
     *                     In case value is 3, it will sort by product price from smallest to biggest
     * @return list of product DTO
     * @throws Exception
     */
    @Override
    public List<ProductResponseDTO> getCategoryFreeShipping(String category, Boolean freeShipping, Integer order) throws Exception {
        List<Product> lista = this.produtoRepository.getAll().stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category) && p.getFreeShipping() == freeShipping)
                .collect(Collectors.toList());
        if (order == null) return ProductResponseDTO.toDtoList(lista);

        lista = orderList(lista, order);

        return ProductResponseDTO.toDtoList(lista);
    }

    /**
     * Returns {@link List< ProductResponseDTO >} ordererd by the order option algorithm
     * @param listToOrder the list of product to order
     * @param order
     *                     In case value is 0, it will sort by product name from A to Z
     *                     In case value is 1, it will sort by product name from Z to A
     *                     In case value is 2, it will sort by product price from biggest to smallest
     *                     In case value is 3, it will sort by product price from smallest to biggest
     * @return list of Product orderd by the order algorithm option
     */
    private List<Product> orderList(List<Product> listToOrder, int order){
        switch (order) {
            case 0:
                listToOrder = listToOrder.stream()
                        .sorted(Comparator.comparing(Product::getName))
                        .collect(Collectors.toList());
                break;
            case 1:
                listToOrder = listToOrder.stream()
                        .sorted(Comparator.comparing(Product::getName).reversed())
                        .collect(Collectors.toList());
                break;
            case 2:
                listToOrder = listToOrder.stream()
                        .sorted(Comparator.comparing(Product::getPrice).reversed())
                        .collect(Collectors.toList());
                break;
            case 3:
                listToOrder = listToOrder.stream()
                        .sorted(Comparator.comparing(Product::getPrice))
                        .collect(Collectors.toList());
                break;
        }
        return listToOrder;
    }

    /**
     * Returns a {@link List< ProductResponseDTO >} filtered by category value
     *
     * @param category category type
     * @return list of product DTO
     * @throws FileNotFoundException
     */
    public List<ProductResponseDTO> getByCategory(String category) throws FileNotFoundException {
        return ProductResponseDTO.toDtoList(this.produtoRepository.getAll()
                .stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(category)).toList());
    }

    /**
     * Returns {@link List< ProductResponseDTO >} filtered by freeShipping and prestige
     *
     * @param freeShipping whether product offers freeShiping or not.
     * @param prestige     amount of prestige that the product must have at least.
     * @return list of product DTO
     * @throws Exception
     */
    @Override
    public List<ProductResponseDTO> getFreeShippingPrestige(Boolean freeShipping, String prestige) throws Exception {

        return ProductResponseDTO.toDtoList(this.produtoRepository.getAll().stream()
                .filter(p -> p.getFreeShipping() == freeShipping && p.getPrestige().length() >= prestige.length())
                .collect(Collectors.toList()));
    }
}

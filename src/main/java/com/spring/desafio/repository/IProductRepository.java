package com.spring.desafio.repository;

import com.spring.desafio.entity.RequestPurchase;
import com.spring.desafio.entity.Product;
import com.spring.desafio.exception.FileNotFoundException;
import com.spring.desafio.exception.ProductNotExistsException;

import java.util.List;

public interface IProductRepository {

    List<Product> getAll() throws FileNotFoundException;

    List<Product> saveAll(List<Product> productList) throws Exception;

    Product getProductById(Long id) throws FileNotFoundException, ProductNotExistsException;

    void updateStorage(List<RequestPurchase> requestPurchaseList) throws FileNotFoundException;

}

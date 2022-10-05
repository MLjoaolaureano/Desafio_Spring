package com.example.demo.repository;

import com.example.demo.entity.Produto;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class ProdutoRepository implements IProdutoRepository{
    private final String linkFile = "src/main/resources/products.json";
    ObjectMapper mapper = new ObjectMapper();

    public void getAll() {
        List<Produto> produtos = null;
        try {
            produtos = Arrays.asList(mapper.readValue(new File(linkFile), Produto[].class));
        }catch (Exception ex) {

        }

        System.out.println(produtos);
//        return produtos;
    }
}

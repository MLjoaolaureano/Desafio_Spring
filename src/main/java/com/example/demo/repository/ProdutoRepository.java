package com.example.demo.repository;

import com.example.demo.entity.Produto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProdutoRepository implements IProdutoRepository{
    private final String linkFile = "src/main/resources/products.json";
    ObjectMapper mapper = new ObjectMapper();

    public List<Produto> getAll() {
        List<Produto> produtos = null;
        try {
            produtos = Arrays.asList(mapper.readValue(new File(linkFile), Produto[].class));
        }catch (Exception ex) {

        }

        return produtos;
    }
}

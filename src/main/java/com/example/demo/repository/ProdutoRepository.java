package com.example.demo.repository;

import com.example.demo.entity.Produto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProdutoRepository implements IProdutoRepository {
    private final String linkFile = "src/main/resources/products.json";
    ObjectMapper mapper = new ObjectMapper();

    public List<Produto> getAll() {

            File storeFile = new File(linkFile);
            List<Produto> produtos = null;
        try {
            produtos = Arrays.asList(mapper.readValue(storeFile, Produto[].class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return produtos;

    }
}

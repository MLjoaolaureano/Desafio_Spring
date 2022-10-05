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

    public List<Produto> getAll() throws  IOException {
        File storeFile = new File(linkFile);
        if (storeFile.exists() && !storeFile.isDirectory()) {
            List<Produto> produtos = null;
            produtos = Arrays.asList(mapper.readValue(storeFile, Produto[].class));
            return produtos;
        } else {
            throw new IOException("Arquivo de armazenamento não encontrado");
        }
    }
}

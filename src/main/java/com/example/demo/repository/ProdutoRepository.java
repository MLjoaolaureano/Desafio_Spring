package com.example.demo.repository;

import com.example.demo.entity.Produto;
import com.example.demo.exception.FileNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProdutoRepository implements IProdutoRepository {
    private final String linkFile = "src/main/resources/products.json";
    ObjectMapper mapper = new ObjectMapper();
    ObjectWriter writer = mapper.writer();

    public List<Produto> getAll() throws FileNotFoundException{

        File storeFile = new File(linkFile);
        List<Produto> produtos = null;
        try {
            produtos = Arrays.asList(mapper.readValue(storeFile, Produto[].class));
        } catch (IOException e) {
            throw new FileNotFoundException("Arquivo não encontrado");
        }
        return produtos;

    }

    public List<Produto> saveAll(List<Produto> produtoList) throws Exception {
        List<Produto> copylist = null;
        try {
            List<Produto> actualList = Arrays.asList(mapper.readValue(new File(linkFile), Produto[].class));
            for (Produto produto : produtoList) {
                if (actualList.stream().map(Produto::getProductId).toList().contains(produto.getProductId())) {
                    throw new Exception("Id " + produto.getProductId() + " já existente.");
                }
            }

            copylist = new ArrayList<>(actualList);
            copylist.addAll(produtoList);
            writer.writeValue(new File(linkFile), copylist);
        } catch (Exception ex) {
            throw ex;
        }

        return produtoList;
    }

}

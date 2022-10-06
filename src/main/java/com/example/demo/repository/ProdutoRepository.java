package com.example.demo.repository;

import com.example.demo.entity.Produto;
import com.example.demo.exception.ExistentProductIdException;
import com.example.demo.exception.FileNotFoundException;
import com.example.demo.exception.ProdutoNotExistsException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class ProdutoRepository implements IProdutoRepository {
    private final String linkFile = "src/main/resources/products.json";
    ObjectMapper mapper = new ObjectMapper();
    ObjectWriter writer = mapper.writer();

    public List<Produto> getAll() throws FileNotFoundException {

        File storeFile = new File(linkFile);
        List<Produto> produtos = null;
        try {
            produtos = Arrays.asList(mapper.readValue(storeFile, Produto[].class));
        } catch (IOException e) {
            throw new FileNotFoundException("Arquivo não encontrado.");
        }
        return produtos;
    }

    public List<Produto> saveAll(List<Produto> produtoList) throws ExistentProductIdException, FileNotFoundException {
        List<Produto> copylist;
        try {
            List<Produto> actualList = Arrays.asList(mapper.readValue(new File(linkFile), Produto[].class));
            for (Produto produto : produtoList) {
                if (actualList.stream().map(Produto::getProductId).toList().contains(produto.getProductId())) {
                    throw new ExistentProductIdException("Id " + produto.getProductId() + " já existente.");
                }
            }

            copylist = new ArrayList<>(actualList);
            copylist.addAll(produtoList);
            writer.writeValue(new File(linkFile), copylist);
        } catch (IOException e) {
            throw new FileNotFoundException("Arquivo não encontrado.");
        } catch (ExistentProductIdException e) {
            throw new ExistentProductIdException("Id do produto fornecido já existe.");
        }

        return produtoList;
    }

    public Produto getProdutoById(Long id) throws FileNotFoundException, ProdutoNotExistsException {
        File storeFile = new File(linkFile);
        List<Produto> produtos = null;
        try {
            produtos = Arrays.asList(mapper.readValue(storeFile, Produto[].class));
        } catch (IOException e) {
            throw new FileNotFoundException("Arquivo não encontrado");
        }
        Optional<Produto> optionalProduto = produtos.stream().filter((p) -> p.getProductId().equals(id)).findFirst();
        if (optionalProduto.isEmpty()) {
            throw new ProdutoNotExistsException("Produto " + id + " não existe");
        } else {
            return optionalProduto.get();
        }
    }

}

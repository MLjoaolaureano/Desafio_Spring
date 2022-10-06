package com.spring.desafio.repository;

import com.spring.desafio.entity.PedidoCompra;
import com.spring.desafio.entity.Produto;
import com.spring.desafio.exception.ExistentProductIdException;
import com.spring.desafio.exception.FileNotFoundException;
import com.spring.desafio.exception.ProdutoNotExistsException;
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
            throw new ProdutoNotExistsException("Produto não existe");
        } else {
            return optionalProduto.get();
        }
    }

    @Override
    public void savePedidoCompra(List<PedidoCompra> pedidoCompraList) throws FileNotFoundException {
        try {
            List<Produto> actualList = Arrays.asList(mapper.readValue(new File(linkFile), Produto[].class));
            List<Produto> newList = new ArrayList<>(actualList);

            actualList.stream().forEach(item -> {
                for (int i = 0; i < pedidoCompraList.size(); i++) {
                    if (item.getProductId() == pedidoCompraList.get(i).getProductId()){
                        newList.get(i).setQuantity(item.getQuantity() - pedidoCompraList.get(i).getQuantity());
                    }
                }
            });
            writer.writeValue(new File(linkFile), newList);
        } catch (IOException e) {
            throw new FileNotFoundException("Arquivo não encontrado.");
        }
    }

}

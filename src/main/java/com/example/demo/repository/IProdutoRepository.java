package com.example.demo.repository;

import com.example.demo.entity.Produto;

<<<<<<< HEAD
=======
import java.io.FileNotFoundException;
>>>>>>> 3a3b77c5f4e2adfa0f35e7b5ff7f8c1b119a555f
import java.io.IOException;
import java.util.List;

public interface IProdutoRepository {

    List<Produto> getAll() throws IOException;

    List<Produto> saveAll(List<Produto> produtoList) throws Exception;

}

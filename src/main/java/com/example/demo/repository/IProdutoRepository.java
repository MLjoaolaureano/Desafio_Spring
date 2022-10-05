package com.example.demo.repository;

import com.example.demo.entity.Produto;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface IProdutoRepository {

    public List<Produto> getAll();

}

package com.example.demo.controller;


import com.example.demo.entity.Produto;
import com.example.demo.service.IProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    private final IProdutoService produtoService;


    public ProdutoController(IProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> getAllProduto(){
        return ResponseEntity.ok(this.produtoService.getAll());
    }
}

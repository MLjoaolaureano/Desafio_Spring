package com.example.demo.controller;


import com.example.demo.entity.Produto;
import com.example.demo.service.IProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/categoriaFreteGratis")
    public ResponseEntity<List<Produto>> getCategoryFreeShipping(@RequestParam String category, @RequestParam Boolean freeShipping){
        return ResponseEntity.ok(this.produtoService.getCategoryFreeShipping(category, freeShipping));
    }
}

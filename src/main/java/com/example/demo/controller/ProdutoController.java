package com.example.demo.controller;


import com.example.demo.entity.PedidoCompra;
import com.example.demo.entity.Produto;
import com.example.demo.entity.TicketCompra;
import com.example.demo.service.IProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("produto")
public class ProdutoController {

    private final IProdutoService produtoService;


    public ProdutoController(IProdutoService produtoService) {
        this.produtoService = produtoService;
    }


    @GetMapping
    public ResponseEntity<List<Produto>> getAllProduto() throws IOException {
        return ResponseEntity.ok(this.produtoService.getAll());
    }

    @PostMapping
    public ResponseEntity<List<Produto>> saveAllProduto(@RequestBody List<Produto> produtoList) throws Exception {
        return ResponseEntity.ok(this.produtoService.saveAll(produtoList));
    }


}

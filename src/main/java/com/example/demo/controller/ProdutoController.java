package com.example.demo.controller;


import com.example.demo.entity.Produto;
import com.example.demo.service.IProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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

    @GetMapping("/categoriaFreteGratis")
    public ResponseEntity<List<Produto>> getCategoryFreeShipping(@RequestParam String category, @RequestParam Boolean freeShipping) throws Exception{
        return ResponseEntity.ok(this.produtoService.getCategoryFreeShipping(category, freeShipping));
    }

    @GetMapping("/freteGratisAvaliacao")
    public ResponseEntity<List<Produto>> getFreeShippingPrestige(@RequestParam Boolean freeShipping, @RequestParam String prestige) throws Exception{
        return ResponseEntity.ok(this.produtoService.getFreeShippingPrestige(freeShipping, prestige));
    }

}

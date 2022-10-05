package com.spring.desafio.controller;


import com.spring.desafio.controller.dto.ProdutoResponseDTO;
import com.spring.desafio.entity.Produto;
import com.spring.desafio.service.IProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/articles")
public class ProdutoController {

    private final IProdutoService produtoService;

    public ProdutoController(IProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping()
    public ResponseEntity<List<ProdutoResponseDTO>> getAllProduto() throws IOException {
        return ResponseEntity.ok(this.produtoService.getAll());
    }

    @PostMapping("/insert-articles-request")
    public ResponseEntity<List<ProdutoResponseDTO>> saveAllProduto(@RequestBody List<Produto> produtoList) throws Exception {
        List<ProdutoResponseDTO> response = this.produtoService.saveAll(produtoList);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/category-free-shipping")
    public ResponseEntity<List<ProdutoResponseDTO>> getCategoryFreeShipping(@RequestParam String category, @RequestParam Boolean freeShipping,  @RequestParam(required = false) Integer order) throws Exception{
        return ResponseEntity.ok(this.produtoService.getCategoryFreeShipping(category, freeShipping, order));
    }

    @GetMapping("/filter")
    public ResponseEntity<List<ProdutoResponseDTO>> getProductByCategory(@RequestParam("category") String category) throws Exception {
        return ResponseEntity.ok(this.produtoService.getByCategory(category));
    }

    @GetMapping("/free-shipping-prestige")
    public ResponseEntity<List<ProdutoResponseDTO>> getFreeShippingPrestige(@RequestParam Boolean freeShipping, @RequestParam String prestige) throws Exception{
        return ResponseEntity.ok(this.produtoService.getFreeShippingPrestige(freeShipping, prestige));
    }

}

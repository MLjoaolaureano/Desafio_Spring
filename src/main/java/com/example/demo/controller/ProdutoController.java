package com.example.demo.controller;


import com.example.demo.controller.dto.ProdutoResponseDTO;
import com.example.demo.entity.Produto;
import com.example.demo.service.IProdutoService;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<ProdutoResponseDTO>> saveAllProduto(@RequestBody List<Produto> produtoList) throws Exception {
        List<ProdutoResponseDTO> response = ProdutoResponseDTO.toDtoList(this.produtoService.saveAll(produtoList));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/categoriaFreteGratis")
    public ResponseEntity<List<Produto>> getCategoryFreeShipping(@RequestParam String category, @RequestParam Boolean freeShipping,  @RequestParam(required = false) Integer order) throws Exception{
        return ResponseEntity.ok(this.produtoService.getCategoryFreeShipping(category, freeShipping, order));
    }

    @GetMapping("/filtrar")
    public ResponseEntity<List<Produto>> getProductByCategory(@RequestParam("category") String category) throws Exception {
        return ResponseEntity.ok(this.produtoService.getByCategory(category));
    }

    @GetMapping("/freteGratisAvaliacao")
    public ResponseEntity<List<Produto>> getFreeShippingPrestige(@RequestParam Boolean freeShipping, @RequestParam String prestige) throws Exception{
        return ResponseEntity.ok(this.produtoService.getFreeShippingPrestige(freeShipping, prestige));
    }

}

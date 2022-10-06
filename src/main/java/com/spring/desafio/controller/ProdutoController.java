package com.spring.desafio.controller;


import com.spring.desafio.controller.dto.ProdutoResponseDTO;
import com.spring.desafio.entity.PedidoCompra;
import com.spring.desafio.entity.Produto;
import com.spring.desafio.service.IProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * Main controller for {@link Produto} entity
 */
@RestController
@RequestMapping("/api/v1/articles")
public class ProdutoController {

    private final IProdutoService produtoService;

    public ProdutoController(IProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    /**
     * GET endpoint to return a {@link List<ProdutoResponseDTO>} list of all available
     *
     * @return a product DTO list
     * @throws IOException
     */
    @GetMapping()
    public ResponseEntity<List<ProdutoResponseDTO>> getAllProduto() throws IOException {
        return ResponseEntity.ok(this.produtoService.getAll());
    }

    /**
     * POST endpoint to store a {@link List<Produto>} list.
     *
     * @param produtoList list of all products to be inserted.
     * @return a product DTO list of all products inserted.
     * @throws Exception
     */
    @PostMapping("/insert-articles-request")
    public ResponseEntity<List<ProdutoResponseDTO>> saveAllProduto(@RequestBody List<Produto> produtoList) throws Exception {
        List<ProdutoResponseDTO> response = this.produtoService.saveAll(produtoList);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    /**
     * GET endpoint to return a {@link List<ProdutoResponseDTO>} list of products filtered by Category and FreeShipping properties.
     * Return might or not be ordered
     *
     * @param category     category field to filter by
     * @param freeShipping whether product offers freeShipping or not
     * @param order        order algorithm to be applied
     * @return a product DTO list
     * @throws Exception
     */
    @GetMapping("/category-free-shipping")
    public ResponseEntity<List<ProdutoResponseDTO>> getCategoryFreeShipping(@RequestParam String category, @RequestParam Boolean freeShipping, @RequestParam(required = false) Integer order) throws Exception {
        return ResponseEntity.ok(this.produtoService.getCategoryFreeShipping(category, freeShipping, order));
    }

    /**
     * GET endpoint to return a {@link List<ProdutoResponseDTO>} list of products filtered by Category
     *
     * @param category
     * @return a product DTO list
     * @throws Exception
     */
    @GetMapping("/filter")
    public ResponseEntity<List<ProdutoResponseDTO>> getProductByCategory(@RequestParam("category") String category) throws Exception {
        return ResponseEntity.ok(this.produtoService.getByCategory(category));
    }

    /**
     * GET endpoint to return a {@link List<ProdutoResponseDTO>} list of products filtered by Prestige and FreeShipping properties.
     *
     * @param freeShipping whether product offers freeShipping or not
     * @param prestige     minimum review prestige that product must have
     * @return a product DTO list
     * @throws Exception
     */
    @GetMapping("/free-shipping-prestige")
    public ResponseEntity<List<ProdutoResponseDTO>> getFreeShippingPrestige(@RequestParam Boolean freeShipping, @RequestParam String prestige) throws Exception {
        return ResponseEntity.ok(this.produtoService.getFreeShippingPrestige(freeShipping, prestige));
    }

}

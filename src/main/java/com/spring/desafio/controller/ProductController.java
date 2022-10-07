package com.spring.desafio.controller;


import com.spring.desafio.controller.dto.ProductResponseDTO;
import com.spring.desafio.entity.Product;
import com.spring.desafio.entity.RequestPurchase;
import com.spring.desafio.exception.DuplicatedProductIdException;
import com.spring.desafio.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Main controller for {@link Product} entity
 */
@RestController
@RequestMapping("/api/v1/articles")
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    /**
     * GET endpoint to return a {@link List< ProductResponseDTO >} list of all available
     *
     * @return a product DTO list
     * @throws IOException
     */
    @GetMapping()
    public ResponseEntity<List<ProductResponseDTO>> getAllProduct() throws IOException {
        return ResponseEntity.ok(this.productService.getAll());
    }

    /**
     * POST endpoint to store a {@link List< Product >} list.
     *
     * @param productList list of all products to be inserted.
     * @return a product DTO list of all products inserted.
     * @throws Exception
     */
    @PostMapping("/insert-articles-request")
    public ResponseEntity<List<ProductResponseDTO>> saveAllProduct(@RequestBody List<Product> productList) throws Exception {
        List<Long> productId = new ArrayList<>();

        for (Product product : productList) {
            if (productId.contains(product.getProductId())) {
                throw new DuplicatedProductIdException("O produto com id " + product.getProductId() + " está duplicado.");
            } else {
                productId.add(product.getProductId());
            }
        }
        List<ProductResponseDTO> response = this.productService.saveAll(productList);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    /**
     * GET endpoint to return a {@link List< ProductResponseDTO >} list of products filtered by Category and FreeShipping properties.
     * Return might or not be ordered
     *
     * @param category     category field to filter by
     * @param freeShipping whether product offers freeShipping or not
     * @param order        order algorithm to be applied
     * @return a product DTO list
     * @throws Exception
     */
    @GetMapping("/category-free-shipping")
    public ResponseEntity<List<ProductResponseDTO>> getCategoryFreeShipping(@RequestParam String category, @RequestParam Boolean freeShipping, @RequestParam(required = false) Integer order) throws Exception {
        return ResponseEntity.ok(this.productService.getCategoryFreeShipping(category, freeShipping, order));
    }

    /**
     * GET endpoint to return a {@link List< ProductResponseDTO >} list of products filtered by Category
     *
     * @param category
     * @return a product DTO list
     * @throws Exception
     */
    @GetMapping("/filter")
    public ResponseEntity<List<ProductResponseDTO>> getProductByCategory(@RequestParam("category") String category) throws Exception {
        return ResponseEntity.ok(this.productService.getByCategory(category));
    }

    /**
     * GET endpoint to return a {@link List< ProductResponseDTO >} list of products filtered by Prestige and FreeShipping properties.
     *
     * @param freeShipping whether product offers freeShipping or not
     * @param prestige     minimum review prestige that product must have
     * @return a product DTO list
     * @throws Exception
     */
    @GetMapping("/free-shipping-prestige")
    public ResponseEntity<List<ProductResponseDTO>> getFreeShippingPrestige(@RequestParam Boolean freeShipping, @RequestParam String prestige) throws Exception {
        return ResponseEntity.ok(this.productService.getFreeShippingPrestige(freeShipping, prestige));
    }

}

package com.spring.desafio.controller.dto;


import com.spring.desafio.entity.Product;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

/**
 * {@link Product} DTO format
 */
@Getter
public class ProductResponseDTO {

    /**
     * Product ID
     */
    private Long productId;
    /**
     * Product Name
     */
    private String name;
    /**
     * Product quantity available
     */
    private Integer quantity;

    ProductResponseDTO(Product product) {
        this.productId = product.getProductId();
        this.name = product.getName();
        this.quantity = product.getQuantity();
    }

    /**
     * Parses a {@link List< Product >} to {@link List< ProductResponseDTO >}
     *
     * @param productList list of product to be parsed
     * @return a product DTO list
     */
    public static List<ProductResponseDTO> toDtoList(List<Product> productList) {
        List<ProductResponseDTO> productResponseDTOList = new ArrayList<>();
        productList.forEach(p -> productResponseDTOList.add(new ProductResponseDTO(p)));
        return productResponseDTOList;
    }

}

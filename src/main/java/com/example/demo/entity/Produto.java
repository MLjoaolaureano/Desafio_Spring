package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
    Long productId;
    String name;
    String category;
    String brand;
    BigDecimal price;
    Integer quantity;
    Boolean freeShipping;
    String prestige;

}

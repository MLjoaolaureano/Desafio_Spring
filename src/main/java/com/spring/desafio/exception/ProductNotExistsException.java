package com.spring.desafio.exception;

import com.spring.desafio.entity.Product;

/**
 * This class is used as an Exception when the {@link Product} does not exist in some required location
 */
public class ProductNotExistsException extends Exception {
    public ProductNotExistsException(String message) {
        super(message);
    }
}

package com.spring.desafio.exception;

/**
 * This class is used as Exception when the product quantity is not enough for some operation
 */
public class ProductQuantityNotSufficientException extends Exception {
    public ProductQuantityNotSufficientException(String message) {
        super(message);
    }
}

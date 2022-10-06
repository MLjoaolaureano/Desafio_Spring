package com.spring.desafio.exception;

/**
 * This class is used as Exception when the product quantity is not enough for some operation
 */
public class ProdutoQuantityNotSufficientException extends Exception {
    public ProdutoQuantityNotSufficientException(String message) {
        super(message);
    }
}

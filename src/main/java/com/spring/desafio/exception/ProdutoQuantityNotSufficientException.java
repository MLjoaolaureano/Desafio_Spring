package com.spring.desafio.exception;

public class ProdutoQuantityNotSufficientException extends Exception {
    public ProdutoQuantityNotSufficientException(String message) {
        super(message);
    }
}

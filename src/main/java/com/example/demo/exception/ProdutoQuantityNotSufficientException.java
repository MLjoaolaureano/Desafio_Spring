package com.example.demo.exception;

public class ProdutoQuantityNotSufficientException extends Exception {
    public ProdutoQuantityNotSufficientException(String message) {
        super(message);
    }
}

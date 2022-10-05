package com.example.demo.exception;

public class ProdutoNotExistsException extends Exception {
    public ProdutoNotExistsException(String message) {
        super(message);
    }
}

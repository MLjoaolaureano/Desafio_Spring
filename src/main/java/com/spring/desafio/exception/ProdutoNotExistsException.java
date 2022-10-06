package com.spring.desafio.exception;

/**
 * This class is used as an Exception when the {@link com.spring.desafio.entity.Produto} does not exist in some required location
 */
public class ProdutoNotExistsException extends Exception {
    public ProdutoNotExistsException(String message) {
        super(message);
    }
}

package com.spring.desafio.exception;

/**
 * This class is used as an Exception when the {@link com.spring.desafio.entity.Produto} already exists in some operation
 */
public class ExistentProductIdException extends Exception {

    public ExistentProductIdException(String message) {
        super(message);
    }
}

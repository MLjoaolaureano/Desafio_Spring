package com.spring.desafio.exception;

import com.spring.desafio.entity.Product;

/**
 * This class is used as an Exception when the {@link Product} already exists in some operation
 */
public class ExistentProductIdException extends Exception {

    public ExistentProductIdException(String message) {
        super(message);
    }
}

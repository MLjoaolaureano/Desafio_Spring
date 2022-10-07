package com.spring.desafio.exception;

import com.spring.desafio.entity.Product;

/**
 * This class is used as an Exception when duplicated {@link Product} Id is pass to perform operation
 */
public class DuplicatedProductIdException extends Exception {

    public DuplicatedProductIdException(String message) {
        super(message);
    }
}

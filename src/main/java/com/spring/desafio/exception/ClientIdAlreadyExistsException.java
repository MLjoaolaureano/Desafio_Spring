package com.spring.desafio.exception;

/**
 * This class is used as an Exception when the {@link com.spring.desafio.entity.Client} Id already exists in some operation
 */
public class ClientIdAlreadyExistsException extends Exception {
    public ClientIdAlreadyExistsException(String message) {
        super(message);
    }
}

package com.spring.desafio.exception;

/**
 * This class is used as an Exception when the {@link com.spring.desafio.entity.Client} CPF already exists in some operation
 */
public class ClientCPFAlreadyExistsException extends Exception {
    public ClientCPFAlreadyExistsException(String message) {
        super(message);
    }
}

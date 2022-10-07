package com.spring.desafio.exception;

/**
 * This class is used as an Exception when the {@link com.spring.desafio.entity.Cliente} already exists in some operation
 */
public class ClientCPFAlreadyExists extends Exception {
    public ClientCPFAlreadyExists(String message) {
        super(message);
    }
}

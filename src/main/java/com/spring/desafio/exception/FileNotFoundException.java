package com.spring.desafio.exception;

import java.io.IOException;
/**
 * This class is used as an Exception when a required file does not exist
 */
public class FileNotFoundException extends IOException {

    public FileNotFoundException(String message){
        super(message);
    }
}

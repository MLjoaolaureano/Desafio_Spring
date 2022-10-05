package com.example.demo.exception;

import java.io.IOException;

public class FileNotFoundException extends IOException {

    public FileNotFoundException(String message){
        super(message);
    }
}

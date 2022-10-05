package com.example.demo.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class HandlerExceptions {

    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<ExceptionDetails> handlerNotFoundException(FileNotFoundException ex) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("Arquivo de armazenamento não encontrado")
                .message(ex.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .timeStamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProdutoNotExistsException.class)
    public ResponseEntity<ExceptionDetails> handlerProdutoNotExistException(ProdutoNotExistsException ex) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("Produto não encontrado")
                .message(ex.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .timeStamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }

}
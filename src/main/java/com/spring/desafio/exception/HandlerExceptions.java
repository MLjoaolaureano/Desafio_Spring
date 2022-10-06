package com.spring.desafio.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class HandlerExceptions {

    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<ExceptionDetails> handlerFileNotFoundException(FileNotFoundException ex) {
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

    @ExceptionHandler(ProdutoQuantityNotSufficientException.class)
    public ResponseEntity<ExceptionDetails> handlerProdutoQuantityNotSufficientException(ProdutoQuantityNotSufficientException ex) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("Quantidade de produto é insuficiente")
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .timeStamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExistentProductIdException.class)
    public ResponseEntity<ExceptionDetails> handlerExistentProductIdException(ExistentProductIdException ex) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("Id já existente")
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .timeStamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ExceptionDetails> handlerExistentProductIdException(HttpRequestMethodNotSupportedException ex) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("Método não suportado")
                .message("Método " + ex.getMethod() + " não suportado nessa rota.")
                .status(HttpStatus.METHOD_NOT_ALLOWED.value())
                .timeStamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.METHOD_NOT_ALLOWED);
    }

}
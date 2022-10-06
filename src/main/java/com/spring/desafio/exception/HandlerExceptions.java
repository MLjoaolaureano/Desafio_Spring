package com.spring.desafio.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

/**
 * This class is used to handle all the checked Exception in Spring environment.
 */
@ControllerAdvice
public class HandlerExceptions {

    /**
     * This function handles {@link FileNotFoundException} exception
     *
     * @param ex
     * @return a response for the client, using {@link ExceptionDetails}
     */
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

    /**
     * This function handles {@link ProdutoNotExistsException} exception
     *
     * @param ex
     * @return a response for the client, using {@link ExceptionDetails}
     */
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

    /**
     * This function handles {@link ProdutoQuantityNotSufficientException} exception
     *
     * @param ex
     * @return a response for the client, using {@link ExceptionDetails}
     */

    @ExceptionHandler(ProdutoQuantityNotSufficientException.class)
    public ResponseEntity<ExceptionDetails> handlerProdutoNotExistException(ProdutoQuantityNotSufficientException ex) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("Quantidade de produto é insuficiente")
                .message(ex.getMessage())
                .status(HttpStatus.NOT_ACCEPTABLE.value())
                .timeStamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_ACCEPTABLE);
    }


    /**
     * This function handles {@link ExistentProductIdException} exception
     *
     * @param ex
     * @return a response for the client, using {@link ExceptionDetails}
     */
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

}
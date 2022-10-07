package com.spring.desafio.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
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
     * This function handles {@link ProductNotExistsException} exception
     *
     * @param ex
     * @return a response for the client, using {@link ExceptionDetails}
     */
    @ExceptionHandler(ProductNotExistsException.class)
    public ResponseEntity<ExceptionDetails> handlerProdutoNotExistException(ProductNotExistsException ex) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("Produto não encontrado")
                .message(ex.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .timeStamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }

    /**
     * This function handles {@link ProductQuantityNotSufficientException} exception
     *
     * @param ex
     * @return a response for the client, using {@link ExceptionDetails}
     */

    @ExceptionHandler(ProductQuantityNotSufficientException.class)
    public ResponseEntity<ExceptionDetails> handlerProdutoQuantityNotSufficientException(ProductQuantityNotSufficientException ex) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("Quantidade de produto é insuficiente")
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .timeStamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
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

    /**
     * This function handles {@link ClientIdAlreadyExists} exception
     *
     * @param ex
     * @return a response for the client, using {@link ExceptionDetails}
     */

    @ExceptionHandler(ClientIdAlreadyExists.class)
    public ResponseEntity<ExceptionDetails> handlerExistentProductIdException(ClientIdAlreadyExists ex) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("ID de Cliente já existente")
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .timeStamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
    }

    /**
     * This function handles {@link ClientIdAlreadyExists} exception
     *
     * @param ex
     * @return a response for the client, using {@link ExceptionDetails}
     */

    @ExceptionHandler(ClientCPFAlreadyExists.class)
    public ResponseEntity<ExceptionDetails> handlerExistentProductIdException(ClientCPFAlreadyExists ex) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("CPF de Cliente já existente")
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .timeStamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
    }

}
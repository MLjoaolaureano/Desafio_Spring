package com.spring.desafio.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

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
    public ResponseEntity<ExceptionDetails> handlerProductNotExistsException(ProductNotExistsException ex) {
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
    public ResponseEntity<ExceptionDetails> handlerProductQuantityNotSufficientException(ProductQuantityNotSufficientException ex) {
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
    public ResponseEntity<ExceptionDetails> handlerHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException ex) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("Método não suportado")
                .message("Método " + ex.getMethod() + " não suportado nessa rota.")
                .status(HttpStatus.METHOD_NOT_ALLOWED.value())
                .timeStamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.METHOD_NOT_ALLOWED);
    }

    /**
     * This function handles {@link ClientIdAlreadyExistsException} exception
     *
     * @param ex
     * @return a response for the client, using {@link ExceptionDetails}
     */

    @ExceptionHandler(ClientIdAlreadyExistsException.class)
    public ResponseEntity<ExceptionDetails> handlerClientIdAlreadyExistsException(ClientIdAlreadyExistsException ex) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("ID de Cliente já existente")
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .timeStamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
    }

    /**
     * This function handles {@link ClientCPFAlreadyExistsException} exception
     *
     * @param ex
     * @return a response for the client, using {@link ExceptionDetails}
     */

    @ExceptionHandler(ClientCPFAlreadyExistsException.class)
    public ResponseEntity<ExceptionDetails> handlerExistentProductIdException(ClientCPFAlreadyExistsException ex) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("CPF de Cliente já existente")
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .timeStamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
    }

    /**
     * This function handles {@link DuplicatedProductIdException} exception
     *
     * @param ex
     * @return a response for the client, using {@link ExceptionDetails}
     */

    @ExceptionHandler(DuplicatedProductIdException.class)
    public ResponseEntity<ExceptionDetails> handlerDuplicatadeProductIdException(DuplicatedProductIdException ex) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("Id duplicado")
                .message(ex.getMessage())
                .status(HttpStatus.BAD_REQUEST.value())
                .timeStamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
    }

    /**
     * This function handles {@link HttpMessageNotReadableException} exception
     *
     * @param ex
     * @return a response for the client, using {@link ExceptionDetails}
     */

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionDetails> handlerHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("Campo do payload com formato incorreto")
                .message("Campo do payload com formato incorreto")
                .status(HttpStatus.BAD_REQUEST.value())
                .timeStamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
    }

    /**
     * This function handles {@link MethodArgumentTypeMismatchException} exception
     *
     * @param ex
     * @return a response for the client, using {@link ExceptionDetails}
     */

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ExceptionDetails> handlerMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("Parâmetro da requisição com formato incorreto")
                .message("Parâmetro " + ex.getName() + " com valor inválido: " + ex.getValue())
                .status(HttpStatus.BAD_REQUEST.value())
                .timeStamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
    }

    /**
     * This function handles {@link InvalidOrderOptionException} exception
     *
     * @param ex
     * @return a response for the client, using {@link ExceptionDetails}
     */

    @ExceptionHandler(InvalidOrderOptionException.class)
    public ResponseEntity<ExceptionDetails> handlerMethodArgumentTypeMismatchException(InvalidOrderOptionException ex) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("Opção de ordenamento inválido")
                .message("Opção de ordenamento inválido")
                .status(HttpStatus.BAD_REQUEST.value())
                .timeStamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
    }

}
package com.spring.desafio.exception;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * This class is used to build and better specify an Exception that might occur.
 */
@Data
@Builder
public class ExceptionDetails {
    private String title;
    private int status;
    private String message;
    private LocalDateTime timeStamp;
}
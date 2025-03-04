package com.mastercard.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public void handleGlobalException(Exception exception, HttpServletRequest request) {
        System.out.println(exception.getMessage());
    }
}

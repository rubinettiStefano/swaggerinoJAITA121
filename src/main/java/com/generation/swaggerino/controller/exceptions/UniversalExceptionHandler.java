package com.generation.swaggerino.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class UniversalExceptionHandler 
{
    
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String entityNotFoundHandler(EntityNotFoundException e)
    {
        return e.getMessage();
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String methodArgumentTypeMismatchExceptionHandler(MethodArgumentTypeMismatchException e)
    {
        return "Controlla il tipo delle path variable, è sbagliato";
    }

    @ExceptionHandler(NotNewEntityException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String notNewEntityExceptionHandler(NotNewEntityException e)
    {
        return e.getMessage();
    }
}

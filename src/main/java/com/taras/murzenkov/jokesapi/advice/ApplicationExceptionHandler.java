package com.taras.murzenkov.jokesapi.advice;

import com.taras.murzenkov.jokesapi.dto.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(BAD_REQUEST)
    public ErrorResponse handle(IllegalArgumentException exception) {
        return new ErrorResponse(exception.getMessage());
    }
}

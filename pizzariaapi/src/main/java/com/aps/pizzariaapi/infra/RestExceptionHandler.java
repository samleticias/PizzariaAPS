package com.aps.pizzariaapi.infra;

import com.aps.pizzariaapi.exception.ApplicationException;
import com.aps.pizzariaapi.service.exception.PizzaNotFoundException;
import com.aps.pizzariaapi.service.exception.UserAlreadyExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    private ResponseEntity<RestExceptionMessage> ApplicationExceptionHandler(ApplicationException exception){
        RestExceptionMessage exceptionResponse = new RestExceptionMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }

    @ExceptionHandler(PizzaNotFoundException.class)
    private ResponseEntity<RestExceptionMessage> PizzaNotFoundExceptionHandler(PizzaNotFoundException exception){
        RestExceptionMessage exceptionResponse = new RestExceptionMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    private ResponseEntity<RestExceptionMessage> UserAlreadyExistsExceptionHandler(UserAlreadyExistsException exception) {
        RestExceptionMessage exceptionResponse = new RestExceptionMessage(HttpStatus.BAD_REQUEST, exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
    }
}

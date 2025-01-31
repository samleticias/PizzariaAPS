package com.aps.pizzariaapi.service.exception;

import com.aps.pizzariaapi.exception.ApplicationException;

public class PizzaNotFoundException extends ApplicationException {
    public PizzaNotFoundException(String message) {
        super(message);
    }
}

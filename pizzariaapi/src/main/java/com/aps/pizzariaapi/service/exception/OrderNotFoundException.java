package com.aps.pizzariaapi.service.exception;

import com.aps.pizzariaapi.exception.ApplicationException;

public class OrderNotFoundException extends ApplicationException {
    public OrderNotFoundException(String message) {
        super(message);
    }
}

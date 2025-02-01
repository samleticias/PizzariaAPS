package com.aps.pizzariaapi.service.exception;

import com.aps.pizzariaapi.exception.ApplicationException;

public class OrderNotFound extends ApplicationException {
    public OrderNotFound(String message) {
        super(message);
    }
}

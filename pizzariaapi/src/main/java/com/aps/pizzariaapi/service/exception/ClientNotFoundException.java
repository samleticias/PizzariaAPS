package com.aps.pizzariaapi.service.exception;

import com.aps.pizzariaapi.exception.ApplicationException;

public class ClientNotFoundException extends ApplicationException {
    public ClientNotFoundException(String message) {
        super(message);
    }
}

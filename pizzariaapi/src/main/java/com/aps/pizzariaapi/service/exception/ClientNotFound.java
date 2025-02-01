package com.aps.pizzariaapi.service.exception;

import com.aps.pizzariaapi.exception.ApplicationException;

public class ClientNotFound extends ApplicationException {
    public ClientNotFound(String message) {
        super(message);
    }
}

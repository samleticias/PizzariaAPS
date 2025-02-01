package com.aps.pizzariaapi.service.exception;

import com.aps.pizzariaapi.exception.ApplicationException;

public class AddressNotFound extends ApplicationException {
    public AddressNotFound(String message) {
        super(message);
    }
}

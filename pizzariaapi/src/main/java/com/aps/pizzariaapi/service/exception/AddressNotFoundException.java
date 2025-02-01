package com.aps.pizzariaapi.service.exception;

import com.aps.pizzariaapi.exception.ApplicationException;

public class AddressNotFoundException extends ApplicationException {
    public AddressNotFoundException(String message) {
        super(message);
    }
}

package com.aps.pizzariaapi.infra;

import org.springframework.http.HttpStatus;

public class RestExceptionMessage {
    private HttpStatus status;
    private String message;

    public RestExceptionMessage(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

package com.conecta.autos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)  // 409 Conflict
public class AutoConflictException extends RuntimeException {

    public AutoConflictException(String message) {
        super(message);
    }
}

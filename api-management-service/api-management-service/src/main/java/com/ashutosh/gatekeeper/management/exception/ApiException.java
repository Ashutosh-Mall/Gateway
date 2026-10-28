package com.ashutosh.gatekeeper.management.exception;
import org.springframework.http.HttpStatus;


public class ApiException extends RuntimeException {

    private HttpStatus httpStatus;

    public ApiException(HttpStatus status, String message) {
        super(message);
        this.httpStatus = status;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}

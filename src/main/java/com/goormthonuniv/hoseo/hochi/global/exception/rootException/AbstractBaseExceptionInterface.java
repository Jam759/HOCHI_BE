package com.goormthonuniv.hoseo.hochi.global.exception.rootException;

import org.springframework.http.HttpStatus;

public abstract class AbstractBaseExceptionInterface extends RuntimeException implements BaseExceptionInterface {

    protected final HttpStatus status;
    protected final String errorCode;
    protected final String errorMessage;

    protected AbstractBaseExceptionInterface(HttpStatus status, String errorCode, String errorMessage) {
        super(errorMessage);
        this.status = status;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    @Override
    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getErrorMessage() {
        return errorMessage;
    }


}
package com.goormthonuniv.hoseo.hochi.global.exception;

import com.goormthonuniv.hoseo.hochi.global.exception.rootException.AbstractBaseExceptionInterface;
import org.springframework.http.HttpStatus;

public class ForbiddenExceptionInterface extends AbstractBaseExceptionInterface {
    public ForbiddenExceptionInterface(String message) {
        super(HttpStatus.FORBIDDEN, "FORBIDDEN", message);
    }
}

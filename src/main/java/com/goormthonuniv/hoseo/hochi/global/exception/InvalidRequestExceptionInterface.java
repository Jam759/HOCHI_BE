package com.goormthonuniv.hoseo.hochi.global.exception;

import com.goormthonuniv.hoseo.hochi.global.exception.rootException.AbstractBaseExceptionInterface;
import org.springframework.http.HttpStatus;

public class InvalidRequestExceptionInterface extends AbstractBaseExceptionInterface {
    public InvalidRequestExceptionInterface(String reason) {
        super(HttpStatus.BAD_REQUEST, "INVALID_REQUEST", "잘못된 요청입니다: " + reason);
    }
}

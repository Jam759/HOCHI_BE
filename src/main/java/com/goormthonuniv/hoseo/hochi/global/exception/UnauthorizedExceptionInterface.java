package com.goormthonuniv.hoseo.hochi.global.exception;

import com.goormthonuniv.hoseo.hochi.global.exception.rootException.AbstractBaseExceptionInterface;
import org.springframework.http.HttpStatus;

public class UnauthorizedExceptionInterface extends AbstractBaseExceptionInterface {
    public UnauthorizedExceptionInterface(String devMessage) {
        super(HttpStatus.UNAUTHORIZED, "UNAUTHORIZED", "인증이 필요합니다.", devMessage);
    }
}

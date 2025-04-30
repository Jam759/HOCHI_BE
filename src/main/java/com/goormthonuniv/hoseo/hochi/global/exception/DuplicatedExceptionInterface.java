package com.goormthonuniv.hoseo.hochi.global.exception;

import com.goormthonuniv.hoseo.hochi.global.exception.rootException.AbstractBaseExceptionInterface;
import org.springframework.http.HttpStatus;

public class DuplicatedExceptionInterface extends AbstractBaseExceptionInterface {

    protected DuplicatedExceptionInterface(String errorCode,String target) {
        super(HttpStatus.CONFLICT, errorCode, target + " 이(가) 이미 존재합니다.");
    }

}

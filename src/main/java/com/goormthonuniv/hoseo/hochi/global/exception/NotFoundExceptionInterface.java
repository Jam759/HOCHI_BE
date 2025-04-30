package com.goormthonuniv.hoseo.hochi.global.exception;

import com.goormthonuniv.hoseo.hochi.global.exception.rootException.AbstractBaseExceptionInterface;
import org.springframework.http.HttpStatus;

public class NotFoundExceptionInterface extends AbstractBaseExceptionInterface {
    //리소스를 찾지 못했을때
    protected NotFoundExceptionInterface(String errorCode, String errorMessage) {
        super(HttpStatus.NOT_FOUND, errorCode, errorMessage + " 을(를) 찾을 수 없습니다.");
    }

}

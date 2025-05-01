package com.goormthonuniv.hoseo.hochi.global.exception;

import com.goormthonuniv.hoseo.hochi.global.exception.rootException.AbstractBaseExceptionInterface;
import org.springframework.http.HttpStatus;

public class DuplicatedExceptionInterface extends AbstractBaseExceptionInterface {

    protected DuplicatedExceptionInterface(String errorCode,String devMessage) {
        super(HttpStatus.CONFLICT, errorCode,  "중복된 데이터입니다.", devMessage + "=> 이미 등록되어 있음");
    }

}

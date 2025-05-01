package com.goormthonuniv.hoseo.hochi.global.exception;

import com.goormthonuniv.hoseo.hochi.global.exception.rootException.AbstractBaseExceptionInterface;
import org.springframework.http.HttpStatus;

public class NotFoundExceptionInterface extends AbstractBaseExceptionInterface {
    //리소스를 찾지 못했을때
    protected NotFoundExceptionInterface(String errorCode,String devMessage) {
        super(HttpStatus.NOT_FOUND, errorCode, "요청하신 정보를 찾을 수 없습니다.",devMessage + " => 데이터를 찾지 못했음");
    }

}

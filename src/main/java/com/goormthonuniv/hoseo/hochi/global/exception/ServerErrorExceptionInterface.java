package com.goormthonuniv.hoseo.hochi.global.exception;

import com.goormthonuniv.hoseo.hochi.global.exception.rootException.AbstractBaseExceptionInterface;
import org.springframework.http.HttpStatus;

public class ServerErrorExceptionInterface extends AbstractBaseExceptionInterface {
    public ServerErrorExceptionInterface(String message) {
        super(HttpStatus.INTERNAL_SERVER_ERROR, "SERVER_ERROR", "서버 오류가 발생했습니다: " + message);
    }
}
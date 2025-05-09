package com.goormthonuniv.hoseo.hochi.global.exception.rootException;

import org.springframework.http.HttpStatus;

public interface BaseExceptionInterface {
    HttpStatus getStatus(); // 상태값
    String getErrorCode(); // 에러코드
    String getDevMessage();// 메시지

    String getErrorMessage();
}

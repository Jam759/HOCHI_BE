package com.goormthonuniv.hoseo.hochi.global.exception;

import com.goormthonuniv.hoseo.hochi.global.exception.rootException.AbstractBaseExceptionInterface;
import org.springframework.http.HttpStatus;

public class ForbiddenExceptionInterface extends AbstractBaseExceptionInterface {
    public ForbiddenExceptionInterface(String devMessage) {
        super(HttpStatus.FORBIDDEN, "USER_ROLE_FORBIDDEN","접근 권한이 없습니다",devMessage + " => 권한없음");
    }
}

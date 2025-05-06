package com.goormthonuniv.hoseo.hochi.global.security.refreshToken.exception;

import com.goormthonuniv.hoseo.hochi.global.exception.DuplicatedExceptionInterface;

public class RefreshTokenDuplicateException extends DuplicatedExceptionInterface {
    public RefreshTokenDuplicateException(String devMessage) {
        super("2009","[RefreshToken] " + devMessage);
    }
}

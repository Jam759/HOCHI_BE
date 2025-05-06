package com.goormthonuniv.hoseo.hochi.global.security.refreshToken.exception;

import com.goormthonuniv.hoseo.hochi.global.exception.NotFoundExceptionInterface;

public class RefreshTokenNotFoundException extends NotFoundExceptionInterface {
    public RefreshTokenNotFoundException(String devMessage) {
        super("2004", "[RefreshToken] "+ devMessage);
    }
}

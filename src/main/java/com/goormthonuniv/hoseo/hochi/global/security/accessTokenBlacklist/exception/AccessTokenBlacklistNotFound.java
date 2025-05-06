package com.goormthonuniv.hoseo.hochi.global.security.accessTokenBlacklist.exception;

import com.goormthonuniv.hoseo.hochi.global.exception.NotFoundExceptionInterface;

public class AccessTokenBlacklistNotFound extends NotFoundExceptionInterface {
    public AccessTokenBlacklistNotFound(String devMessage) {
        super("1804", "[AccessTokenBlacklist] " + devMessage);
    }
}

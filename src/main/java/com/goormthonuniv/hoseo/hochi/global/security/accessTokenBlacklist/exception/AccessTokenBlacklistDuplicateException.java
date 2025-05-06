package com.goormthonuniv.hoseo.hochi.global.security.accessTokenBlacklist.exception;

import com.goormthonuniv.hoseo.hochi.global.exception.DuplicatedExceptionInterface;

public class AccessTokenBlacklistDuplicateException extends DuplicatedExceptionInterface {
    public AccessTokenBlacklistDuplicateException(String devMessage) {
        super("1809","[AccessTokenBlacklist] " + devMessage);
    }
}

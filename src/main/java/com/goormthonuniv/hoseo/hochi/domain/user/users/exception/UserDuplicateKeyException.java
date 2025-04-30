package com.goormthonuniv.hoseo.hochi.domain.user.users.exception;

import com.goormthonuniv.hoseo.hochi.global.exception.DuplicatedExceptionInterface;

public class UserDuplicateKeyException extends DuplicatedExceptionInterface {
    public UserDuplicateKeyException( String target) {
        super("1001", target);
    }
}

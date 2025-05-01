package com.goormthonuniv.hoseo.hochi.domain.user.users.exception;

import com.goormthonuniv.hoseo.hochi.global.exception.DuplicatedExceptionInterface;

public class UserDuplicateKeyException extends DuplicatedExceptionInterface {
    public UserDuplicateKeyException( String devMessage) {
        super("1009", "[User] "+devMessage);
    }
}

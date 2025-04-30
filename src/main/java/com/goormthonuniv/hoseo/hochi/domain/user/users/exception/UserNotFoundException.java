package com.goormthonuniv.hoseo.hochi.domain.user.users.exception;

import com.goormthonuniv.hoseo.hochi.global.exception.NotFoundExceptionInterface;

public class UserNotFoundException extends NotFoundExceptionInterface {
    public UserNotFoundException(String errorMessage) {
        super("1004", "[User] "+errorMessage);
    }
}

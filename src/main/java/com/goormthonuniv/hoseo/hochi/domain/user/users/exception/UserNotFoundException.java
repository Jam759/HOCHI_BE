package com.goormthonuniv.hoseo.hochi.domain.user.users.exception;

import com.goormthonuniv.hoseo.hochi.global.exception.NotFoundExceptionInterface;

public class UserNotFoundException extends NotFoundExceptionInterface {
    public UserNotFoundException(String devMessage) {
        super( "1004","[User] "+devMessage);
    }
}

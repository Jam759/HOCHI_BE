package com.goormthonuniv.hoseo.hochi.domain.favorite.userFavoritePlace.exception;

import com.goormthonuniv.hoseo.hochi.global.exception.NotFoundExceptionInterface;

public class UserFavoriteNotFoundException extends NotFoundExceptionInterface {
    public UserFavoriteNotFoundException(String devMessage) {
        super("1104", "[UserFavoritePlace] "+devMessage);
    }
}

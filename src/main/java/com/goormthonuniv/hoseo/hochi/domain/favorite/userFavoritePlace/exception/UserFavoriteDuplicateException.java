package com.goormthonuniv.hoseo.hochi.domain.favorite.userFavoritePlace.exception;

import com.goormthonuniv.hoseo.hochi.global.exception.DuplicatedExceptionInterface;

public class UserFavoriteDuplicateException extends DuplicatedExceptionInterface {
    public UserFavoriteDuplicateException(String devMessage) {
        super("1109", "[UserFavoritePlace] "+devMessage);
    }
}

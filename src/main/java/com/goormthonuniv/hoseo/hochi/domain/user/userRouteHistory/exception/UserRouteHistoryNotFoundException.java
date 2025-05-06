package com.goormthonuniv.hoseo.hochi.domain.user.userRouteHistory.exception;

import com.goormthonuniv.hoseo.hochi.global.exception.NotFoundExceptionInterface;

public class UserRouteHistoryNotFoundException extends NotFoundExceptionInterface {
    public UserRouteHistoryNotFoundException(String devMessage) {
        super("1304", "[UserRouteHistory] "+devMessage);
    }
}

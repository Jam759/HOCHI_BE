package com.goormthonuniv.hoseo.hochi.domain.user.userRouteHistory.exception;

import com.goormthonuniv.hoseo.hochi.global.exception.DuplicatedExceptionInterface;

public class UserRouteHistoryDuplicateException extends DuplicatedExceptionInterface {
    public UserRouteHistoryDuplicateException(String devMessage) {
        super("1209", "[UserRouteHistory] " + devMessage);
    }
}

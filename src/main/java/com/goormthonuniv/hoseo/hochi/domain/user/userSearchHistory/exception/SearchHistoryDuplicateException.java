package com.goormthonuniv.hoseo.hochi.domain.user.userSearchHistory.exception;

import com.goormthonuniv.hoseo.hochi.global.exception.DuplicatedExceptionInterface;

public class SearchHistoryDuplicateException extends DuplicatedExceptionInterface {
    public SearchHistoryDuplicateException(String devMessage) {
        super("1209", "[UserSearchHistory] " + devMessage);
    }
}

package com.goormthonuniv.hoseo.hochi.domain.user.userSearchHistory.exception;

import com.goormthonuniv.hoseo.hochi.global.exception.NotFoundExceptionInterface;

public class SearchHistoryNotFoundException extends NotFoundExceptionInterface {
  public SearchHistoryNotFoundException(String devMessage) {
    super("1204", "[SearchHistory] "+devMessage);
  }
}

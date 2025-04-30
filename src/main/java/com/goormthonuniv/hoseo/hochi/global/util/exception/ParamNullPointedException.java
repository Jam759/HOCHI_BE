package com.goormthonuniv.hoseo.hochi.global.util.exception;

import com.goormthonuniv.hoseo.hochi.global.exception.InvalidRequestExceptionInterface;

public class ParamNullPointedException extends InvalidRequestExceptionInterface {
    public ParamNullPointedException(String reason) {
        super(reason);
    }
}

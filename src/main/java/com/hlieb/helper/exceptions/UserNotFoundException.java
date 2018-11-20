package com.hlieb.helper.exceptions;

public class UserNotFoundException extends Exception {

    private long userId;

    public UserNotFoundException(Long userId) {

        this.userId = userId;

    }
}

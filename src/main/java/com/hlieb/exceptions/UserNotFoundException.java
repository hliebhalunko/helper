package com.hlieb.exceptions;

public class UserNotFoundException extends Exception {

    private long userId;

    public UserNotFoundException(Long userId) {

        this.userId = userId;

    }
}

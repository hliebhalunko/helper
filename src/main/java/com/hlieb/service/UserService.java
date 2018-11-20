package com.hlieb.service;

import com.hlieb.entity.User;
import com.hlieb.dto.UserDTO;
import com.hlieb.exceptions.UserNotFoundException;

public interface UserService {

    long addUser(UserDTO userDTO);

    void removeUser(long userId);

    void updateUser(UserDTO userDTO) throws UserNotFoundException;

    Iterable<User> getAllUsers();
}

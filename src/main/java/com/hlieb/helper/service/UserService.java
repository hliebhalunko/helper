package com.hlieb.helper.service;

import com.hlieb.helper.dto.UserDTO;
import com.hlieb.helper.entity.User;
import com.hlieb.helper.exceptions.UserNotFoundException;

public interface UserService {

    long addUser(UserDTO userDTO);

    void removeUser(long userId);

    void updateUser(UserDTO userDTO) throws UserNotFoundException;

    Iterable<User> getAllUsers();
}

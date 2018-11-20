package com.hlieb.service;

import com.hlieb.dto.response.UserResponseDTO;
import com.hlieb.dto.request.UserRequestDTO;
import com.hlieb.exceptions.UserNotFoundException;

public interface UserService {

    long addUser(UserRequestDTO userRequestDTO);

    void removeUser(long userId);

    void updateUser(UserRequestDTO userRequestDTO) throws UserNotFoundException;

    Iterable<UserResponseDTO> getAllUsers();

    Iterable<UserResponseDTO> getUsersWithNegativeBalance();

    Iterable<UserResponseDTO> getUsersWithPositiveBalance();
}

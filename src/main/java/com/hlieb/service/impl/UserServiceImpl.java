package com.hlieb.service.impl;

import com.hlieb.dto.request.UserRequestDTO;
import com.hlieb.dto.response.UserResponseDTO;
import com.hlieb.entity.User;
import com.hlieb.exceptions.UserNotFoundException;
import com.hlieb.repository.UserRepository;
import com.hlieb.service.UserService;
import com.hlieb.util.DTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponseDTO getUser(long id) throws UserNotFoundException {
        return DTOMapper.userToResponseDTO(userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id)));
    }

    @Override
    public long addUser(UserRequestDTO userRequestDTO) {
        User user = new User();
        DTOMapper.requestDTOtoUser(user, userRequestDTO);
        user.setBalance(0);
        user = userRepository.save(user);
        return user.getId();
    }

    @Override
    public void removeUser(long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public void updateUser(UserRequestDTO userRequestDTO) throws UserNotFoundException {

        Optional<User> userOpt = userRepository.findById(userRequestDTO.getId());
        User user = DTOMapper.requestDTOtoUser(userOpt.orElseThrow(() -> new UserNotFoundException(userRequestDTO.getId())), userRequestDTO);
        userRepository.save(user);

    }

    @Override
    public Iterable<UserResponseDTO> getAllUsers() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .map(DTOMapper::userToResponseDTO).collect(Collectors.toList());
    }

    @Override
    public Iterable<UserResponseDTO> getUsersWithNegativeBalance() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .filter(user -> user.getBalance() < 0)
                .map(DTOMapper::userToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<UserResponseDTO> getUsersWithPositiveBalance() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .filter(user -> user.getBalance() >= 0)
                .map(DTOMapper::userToResponseDTO)
                .collect(Collectors.toList());
    }

}

package com.hlieb.service.impl;

import com.hlieb.dto.UserDTO;
import com.hlieb.entity.User;
import com.hlieb.exceptions.UserNotFoundException;
import com.hlieb.repository.UserRepository;
import com.hlieb.service.UserService;
import com.jcabi.aspects.Loggable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public long addUser(UserDTO userDTO) {
        User user = new User();
        setValuesFromDTO(user, userDTO);
        user = userRepository.save(user);
        return user.getId();
    }

    @Override
    public void removeUser(long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public void updateUser(UserDTO userDTO) throws UserNotFoundException {

        Optional<User> userOpt = userRepository.findById(userDTO.getId());
        User user = setValuesFromDTO(userOpt.orElseThrow(() -> new UserNotFoundException(userDTO.getId())), userDTO);
        userRepository.save(user);

    }

    @Override
    @Loggable
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    private User setValuesFromDTO(User user, UserDTO userDTO) {

        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setNickname(userDTO.getNickname());
        user.setBloodType(userDTO.getBloodType());
        user.setDateOfBirth(LocalDate.parse(userDTO.getDateOfBirth()));
        user.setDateOfEnlistment(LocalDate.parse(userDTO.getDateOfEnlistment()));
        user.setRank(userDTO.getRank());
        user.setUserStatus(userDTO.getUserStatus());

        return user;
    }

}

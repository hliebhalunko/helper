package com.hlieb.controller;

import com.hlieb.dto.request.UserRequestDTO;
import com.hlieb.dto.response.UserResponseDTO;
import com.hlieb.entity.User;
import com.hlieb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> addUser(UserRequestDTO userRequestDTO) {
        long userId = userService.addUser(userRequestDTO);
        return new ResponseEntity<>(userId, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        Iterable<UserResponseDTO> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/negative")
    public ResponseEntity<?> getUsersWithNegativeBalance() {
        Iterable<UserResponseDTO> users = userService.getUsersWithNegativeBalance();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/positive")
    public ResponseEntity<?> getUsersWithPositiveBalance() {
        Iterable<UserResponseDTO> users = userService.getUsersWithPositiveBalance();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable long id) {
        userService.removeUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}

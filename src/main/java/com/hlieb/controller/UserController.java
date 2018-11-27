package com.hlieb.controller;

import com.hlieb.dto.request.UserRequestDTO;
import com.hlieb.dto.response.UserResponseDTO;
import com.hlieb.exceptions.UserNotFoundException;
import com.hlieb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable long id) throws UserNotFoundException {
        UserResponseDTO responseDTO = userService.getUser(id);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable long id) {
        userService.removeUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}

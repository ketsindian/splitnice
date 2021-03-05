package com.splitnice.app.controller;

import com.splitnice.app.model.Balance;
import com.splitnice.app.model.User;
import com.splitnice.app.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {
    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{userId}")
    public User getUser(@Validated @PathVariable long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    @PostMapping("/user")
    public User createUser(@Validated @RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/user/{userId}/balance")
    public List<Balance> getUserBalance(@Validated @PathVariable long userId) {
        return userService.getUserBalance(userId);
    }
}

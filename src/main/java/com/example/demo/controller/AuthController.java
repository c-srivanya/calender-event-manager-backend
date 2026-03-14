package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User loggedUser = userService.loginUser(user.getUsername(), user.getPassword());

        if (loggedUser != null) {
            return "Login Successful";
        }

        return "Invalid Credentials";
    }
}
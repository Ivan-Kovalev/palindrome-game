package com.example.palindrome_game.controller;

import com.example.palindrome_game.model.User;
import com.example.palindrome_game.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping(path = "/leaderboard")
    public List<User> getLeaderboard() {
        return service.getLeaderboard();
    }
}

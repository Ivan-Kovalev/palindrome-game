package com.example.palindrome_game.service.impl;

import com.example.palindrome_game.model.User;
import com.example.palindrome_game.repository.UserRepository;
import com.example.palindrome_game.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> getLeaderboard() {
        return repository.findTopNUserByRate(5);
    }
}

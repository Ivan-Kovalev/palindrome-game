package com.example.palindrome_game.service.impl;

import com.example.palindrome_game.model.User;
import com.example.palindrome_game.repository.UserRepository;
import com.example.palindrome_game.service.GameService;

public class GameServiceImpl implements GameService {

    private final UserRepository repository;

    public GameServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Integer addPalindrome(User user, String str) {
        if (isPalindrome(str) && userAlreadyExist(user)) {
            repository.save(
                    new User(
                            user.getName(),
                            str.length()));
            return str.length();
        } else {
            return 0;
        }
    }

    private boolean isPalindrome(String str) {
        StringBuilder reverseStr = new StringBuilder(str);
        if (reverseStr.reverse().toString().equals(str)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean userAlreadyExist(User user) {
        if (repository.findBy(user)) {
            return false;
        } else {
            return true;
        }
    }
}

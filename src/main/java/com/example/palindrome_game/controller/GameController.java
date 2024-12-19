package com.example.palindrome_game.controller;

import com.example.palindrome_game.model.User;
import com.example.palindrome_game.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/game")
public class GameController {

    private final GameService service;

    public GameController(GameService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Integer> addPalindrome(User user, String str) {
        Integer result = service.addPalindrome(user, str);
        if (result <= 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }
}

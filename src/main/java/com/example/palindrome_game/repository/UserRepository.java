package com.example.palindrome_game.repository;

import com.example.palindrome_game.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean findBy(User user);
}

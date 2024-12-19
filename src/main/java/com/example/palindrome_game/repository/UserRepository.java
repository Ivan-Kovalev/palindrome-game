package com.example.palindrome_game.repository;

import com.example.palindrome_game.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean findBy(User user);

    @Query(value = "SELECT u FROM User u ORDER BY u.rate DESC", nativeQuery = true)
    List<User> findTopNUserByRate(@Param("n") int n);
}

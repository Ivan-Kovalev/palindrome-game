package com.example.palindrome_game.repository;

import com.example.palindrome_game.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean findBy(User user);

    @Query(value = "SELECT u FROM User u ORDER BY u.rate DESC", nativeQuery = true)
    List<User> findTopNUserByRate(@Param("n") int n);
}

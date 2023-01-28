package com.example.springsecurityexamples.repo;

import com.example.springsecurityexamples.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

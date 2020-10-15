package com.music.school.repository;

import com.music.school.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
User findByUsername(String username);
}
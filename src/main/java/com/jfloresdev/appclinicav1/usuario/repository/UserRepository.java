package com.jfloresdev.appclinicav1.usuario.repository;

import com.jfloresdev.appclinicav1.usuario.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
package com.hub.construtora.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hub.construtora.User;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
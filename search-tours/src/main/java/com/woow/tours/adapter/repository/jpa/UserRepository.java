package com.woow.tours.adapter.repository.jpa;

import com.woow.tours.adapter.repository.jpa.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Login, Long> {

    Optional<Login> findByUsername(String username);
}

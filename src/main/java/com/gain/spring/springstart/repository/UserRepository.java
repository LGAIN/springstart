package com.gain.spring.springstart.repository;

import com.gain.spring.springstart.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// @Repository // => 생략가능
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);
}

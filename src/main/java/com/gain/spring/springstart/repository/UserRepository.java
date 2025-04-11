package com.gain.spring.springstart.repository;

import com.gain.spring.springstart.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

// @Repository // => 생략가능
public interface UserRepository extends JpaRepository<UserEntity, Long> {

}

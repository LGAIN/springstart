package com.gain.spring.springstart.service;

import com.gain.spring.springstart.dto.UserDto;
import com.gain.spring.springstart.entity.UserEntity;
import com.gain.spring.springstart.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

/*
 * 이제 Spring Data JPA가 DB에 직접 INSERT 하므로
 * 메모리 리스트에 저장하지 않아도 된다!
 */
//    private final List<UserDto> users = new ArrayList<>();
//
//    public void saveUser (UserDto user) {
//        users.add(user);
//    }
//
//    public List<UserDto> getUsers() {
//        return users;
//    }

    private final UserRepository userRepository;

    // 생성자 주입
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(UserEntity user) {
        userRepository.save(user); // JPA 자동 저장
    }

    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }
}

package com.gain.spring.springstart.service;

import com.gain.spring.springstart.dto.UserDto;
import com.gain.spring.springstart.entity.UserEntity;
import com.gain.spring.springstart.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UserService implements UserDetailsService {
    /*
     * 이제 Spring Data JPA가 DB에 직접 INSERT 하므로
     * 메모리 리스트에 저장하지 않아도 된다!
     */

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    // 생성자 주입
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void signup(UserDto dto) {
        if (userRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new IllegalStateException("이미 가입된 이메일입니다.");
        }

        UserEntity user = new UserEntity();
        user.setEmail(dto.getEmail());
        user.setName(dto.getName());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        System.out.println("회원가입 시도" + user.getEmail());
        userRepository.save(user);
        System.out.println("회원가입 완료" + user.getEmail());
    }

    public UserEntity getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다."));
    }

    @Override
    public UserDetails loadUserByUsername (String email) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("가입하지 않은 이메일"));

        return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .roles("USER")
                .build();
    }




    public void saveUser(UserEntity user) {
        userRepository.save(user); // JPA 자동 저장
    }

    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    public UserEntity getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다."));
    }

    @Transactional
    public void updateUser(Long id, UserEntity updatedUser) {
        UserEntity existing = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("없는 사용자 입니다."));

        existing.setName(updatedUser.getName());
        existing.setEmail(updatedUser.getEmail());
        existing.setAge(updatedUser.getAge());
    }

    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

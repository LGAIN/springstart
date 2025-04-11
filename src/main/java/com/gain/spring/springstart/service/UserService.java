package com.gain.spring.springstart.service;

import com.gain.spring.springstart.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final List<UserDto> users = new ArrayList<>();

    public void saveUser (UserDto user) {
        users.add(user);
    }

    public List<UserDto> getUsers() {
        return users;
    }
}

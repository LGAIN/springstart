package com.gain.spring.springstart.controller;

import com.gain.spring.springstart.dto.UserDto;
import com.gain.spring.springstart.entity.UserEntity;
import com.gain.spring.springstart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class HelloController {
    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello, Spring!";
    }

    @GetMapping("/greet")
    public String greet() {
        return "hello";
    }

    @GetMapping("/form")
    public String form() {
        return "form";
    }

    @PostMapping("/submit")
    public String submit(@ModelAttribute UserEntity userEntity, Model model) {
        userService.saveUser(userEntity); // 유저 저장
        model.addAttribute("user", userEntity);
        return "result";
    }

    @GetMapping("/users")
    public String showUsers(Model model) {
        model.addAttribute("userList", userService.getUsers());
        return "users";
    }
}

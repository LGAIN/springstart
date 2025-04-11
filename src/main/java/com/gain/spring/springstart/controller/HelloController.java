package com.gain.spring.springstart.controller;

import com.gain.spring.springstart.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class HelloController {

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
    public String submit(@ModelAttribute UserDto userDto, Model model) {
        model.addAttribute("user", userDto);
        return "result";
    }

    @GetMapping("/users")
    public String showUsers(Model model) {
        List<UserDto> users = new ArrayList<>();
        users.add(new UserDto("이가인", "lee@mail.com", 20));
        users.add(new UserDto("홍길동", "hong@mail.com", 10));
        model.addAttribute("userList", users);
        return "users";
    }
}

package com.gain.spring.springstart.controller;

import com.gain.spring.springstart.dto.UserDto;
import com.gain.spring.springstart.entity.UserEntity;
import com.gain.spring.springstart.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // GET : 회원가입 화면
    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "signup";
    }

    // POST : 회원가입 처리
    @PostMapping("/signup")
    public String signupSubmit(@ModelAttribute UserDto userDto) {
        userService.signup(userDto); // 유저 저장
//        model.addAttribute("")
        return "redirect:/login";
    }
}
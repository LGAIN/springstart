package com.gain.spring.springstart.controller;

import com.gain.spring.springstart.dto.UserDto;
import com.gain.spring.springstart.entity.PostEntity;
import com.gain.spring.springstart.entity.UserEntity;
import com.gain.spring.springstart.service.PostService;
import com.gain.spring.springstart.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class UserController {

    private final UserService userService;
    private final PostService postService;

    public UserController(UserService userService, PostService postService) {
        this.userService = userService;
        this.postService = postService;
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

    // GET : 마이페이지에서 내 정보 확인
    @GetMapping("/mypage")
    public String mypage(@PageableDefault(size = 5) Pageable pageable, Principal principal, Model model) {
        String email = principal.getName();
        UserEntity user = userService.getUserByEmail(email);
        Page<PostEntity> myPosts = postService.getPostsByWriter(email, pageable);
        model.addAttribute("user", user);
        model.addAttribute("postPage", myPosts);
        return "mypage";
    }
}
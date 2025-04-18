package com.gain.spring.springstart.controller;

import com.gain.spring.springstart.dto.UserDto;
import com.gain.spring.springstart.entity.UserEntity;
import com.gain.spring.springstart.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/users/{id}")
    public String getUserId(@PathVariable Long id, Model model) {
        UserEntity user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "userDetail";
    }

    @GetMapping("/users/{id}/edit")
    public String editUserForm(@PathVariable Long id, Model model) {
        UserEntity user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping("/users/{id}/update")
    public String updateUser(@PathVariable Long id, @ModelAttribute UserEntity updatedUser) {
        userService.updateUser(id, updatedUser);
        return "redirect:/users/" + id;
    }

    @PostMapping("/users/{id}/delete")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}

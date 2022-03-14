package com.spring.training.controller;

import com.spring.training.model.User;
import com.spring.training.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("{id}")
    public User getUser(@PathVariable("id") String id) {
        return userService.getUser(id).orElseThrow(() -> new RuntimeException("user not found"));
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

}

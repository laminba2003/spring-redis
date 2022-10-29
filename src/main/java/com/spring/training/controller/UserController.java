package com.spring.training.controller;

import com.spring.training.model.User;
import com.spring.training.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("{id}")
    public User getUser(@PathVariable("id") String id) {
        return service.getUser(id);
    }

    @GetMapping
    public List<User> getUsers() {
        return service.getUsers();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public User createUser(@Valid @RequestBody User user) {
        return service.createUser(user);
    }

    @PutMapping("{id}")
    public User updateUser(@PathVariable("id") String id, @Valid @RequestBody User user) {
        return service.updateUser(id, user);
    }

    @DeleteMapping("{id}")
    public void updateUser(@PathVariable("id") String id) {
        service.deleteUser(id);
    }

}

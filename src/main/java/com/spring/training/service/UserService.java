package com.spring.training.service;

import com.spring.training.model.User;
import com.spring.training.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@CacheConfig(cacheNames = "User")
public class UserService {

    private final UserRepository repository;

    @Cacheable(key = "#root.method.name")
    public List<User> getUsers() {
        return repository.findAll();
    }

    @Cacheable(key = "#id")
    public Optional<User> getUser(String id) {
        return repository.findById(id);
    }

}
package com.spring.training.service;

import com.spring.training.exception.EntityNotFoundException;
import com.spring.training.model.User;
import com.spring.training.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
@CacheConfig(cacheNames = "User")
public class UserService {

    private final UserRepository repository;

    public List<User> getUsers() {
        return repository.findAll();
    }

    @Cacheable(key = "#id")
    public User getUser(String id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("user not found with id : "+id));
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    @CacheEvict(key = "#id")
    public User updateUser(String id, User user) {
        return repository.findById(id).map(entity -> {
            user.setId(id);
            return repository.save(user);
        }).orElseThrow(() -> new EntityNotFoundException("user not found with id " + id));
    }

    @CacheEvict(key = "#id")
    public void deleteUser(String id) {
        repository.findById(id).ifPresent(user -> repository.delete(user));
    }

}
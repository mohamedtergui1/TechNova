package org.example.service;

;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.List;

public class UserServiceImpl implements UserService {
    UserRepository repository;
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }
    @Override
    public List<User> getUsers() {
        return repository.findAll();
    }

    @Override
    public void saveUser(User user) {
            repository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return repository.getReferenceById(id);
    }

    @Override
    public void updateUser(User user) {
        repository.saveAndFlush(user);
    }

    @Override
    public void deleteUser(Long id) {
        repository.deleteById(id);
    }
}
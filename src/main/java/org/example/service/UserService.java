package org.example.service;

import org.example.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getUsers();

    void saveUser(User user);

    Optional<User> getUserById(Long id);

    void updateUser(User user);

    void deleteUser(Long id);
}

package com.example.vivavis.application.port;

import com.example.vivavis.domain.entity.User;

import java.util.List;

public interface UserServicePort {
    List<User> getAllUsers();
    User getUserById(Long id);
    User createUser(User user);
    User updateUser(Long id, User updatedUser);
    void deleteUser(Long id);
}

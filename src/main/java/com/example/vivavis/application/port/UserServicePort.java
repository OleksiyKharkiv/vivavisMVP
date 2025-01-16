package com.example.vivavis.application.port;

import com.example.vivavis.domain.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserServicePort {
    List<User> getAllUsers();
    User getUserById(UUID id);
    User createUser(User user);
    User updateUser(UUID id, User updatedUser);
    void deleteUser(UUID id);
}

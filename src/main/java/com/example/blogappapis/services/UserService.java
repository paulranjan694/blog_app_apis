package com.example.blogappapis.services;

import com.example.blogappapis.dto.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUser(String userId);
    User createUser(User user);
    User updateUser(String userId, User user);
    String deleteUser(String userId);
}

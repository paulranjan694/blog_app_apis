package com.example.blogappapis.repositoryservices;

import com.example.blogappapis.dto.User;

import java.util.List;

public interface UserRepositoryService {
    List<User> getAllUsers();

    User getUser(String userId);

    User updateUser(String userId, User user);

    String deleteUser(String userId);

    User createUser(User user);
}

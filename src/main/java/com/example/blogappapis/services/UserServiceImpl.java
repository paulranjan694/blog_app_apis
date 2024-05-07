package com.example.blogappapis.services;

import com.example.blogappapis.dto.User;
import com.example.blogappapis.repositoryservices.UserRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepositoryService userRepositoryService;

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        users = userRepositoryService.getAllUsers();
        return users;
    }

    @Override
    public User getUser(String userId) {
        User user;
        user = userRepositoryService.getUser(userId);
        return user;
    }

    @Override
    public User createUser(User user) {
        User createdUser = userRepositoryService.createUser(user);
        return createdUser;
    }
}

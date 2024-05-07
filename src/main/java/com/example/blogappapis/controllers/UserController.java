package com.example.blogappapis.controllers;

import com.example.blogappapis.dto.User;
import com.example.blogappapis.exceptions.BadRequestException;
import com.example.blogappapis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = new ArrayList<>();

        users =userService.getAllUsers();
        ResponseEntity responseEntity = ResponseEntity.ok().body(users);

        return responseEntity;
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<User>> getUser(@PathVariable("userId") String id){
        User user = null;
        user =userService.getUser(id);
        ResponseEntity responseEntity = ResponseEntity.ok().body(user);
        return responseEntity;
    }

    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody User user){
        if(user == null){
            throw new BadRequestException("Bad Request");
        }

        User createdUser = userService.createUser(user);

        return new ResponseEntity<>(String.format("User Created Successfully, user id - %s",createdUser.getUserId()), HttpStatus.CREATED);
    }

}

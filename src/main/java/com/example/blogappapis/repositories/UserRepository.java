package com.example.blogappapis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blogappapis.entities.User;

public interface UserRepository extends JpaRepository<User, String> {

}

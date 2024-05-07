package com.example.blogappapis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blogappapis.entities.UserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

}

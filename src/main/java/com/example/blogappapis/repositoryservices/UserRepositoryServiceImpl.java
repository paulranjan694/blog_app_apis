package com.example.blogappapis.repositoryservices;

import com.example.blogappapis.dto.User;
import com.example.blogappapis.entities.UserEntity;
import com.example.blogappapis.exceptions.ResourceNotFoundException;
import com.example.blogappapis.repositories.UserRepository;
import jakarta.inject.Provider;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserRepositoryServiceImpl implements UserRepositoryService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    Provider<ModelMapper> modelMapperProvider;

    @Override
    public List<User> getAllUsers() {
       List<UserEntity> userEntities = userRepository.findAll();
       List<User> users= new ArrayList<User>();
       ModelMapper  modelMapper = modelMapperProvider.get();

       for(UserEntity userEntity : userEntities){
           users.add(modelMapper.map(userEntity,User.class));
       }
        return users;
    }

    @Override
    public User getUser(String userId) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException(String.format("User with user id %s not found",userId)));
        User user = null;
        user = modelMapperProvider.get().map(userEntity,User.class);
        return user;
    }

    @Override
    public User updateUser(String userId, User user) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException(String.format("User with user id %s not found",userId)));

        if(user.getEmail() != null){
            userEntity.setEmail(user.getEmail());
        }

        if(user.getName() != null){
            userEntity.setName(user.getName());
        }

        if(user.getAbout() != null){
            userEntity.setAbout(user.getAbout());
        }

        UserEntity updatedUserEntity = userRepository.save(userEntity);

        User updatedUser = modelMapperProvider.get().map(userEntity,User.class);

        return updatedUser;
    }

    @Override
    public String deleteUser(String userId) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException(String.format("User with user id %s not found",userId)));
        userRepository.delete(userEntity);
        return String.format("User deleted successfully with id - %s",userEntity.getId());
    }

    @Override
    public User createUser(User user) {
        UserEntity userEntity = modelMapperProvider.get().map(user, UserEntity.class);
        UserEntity userEntityCreated = userRepository.save(userEntity);
        User userCreated = modelMapperProvider.get().map(userEntityCreated, User.class);
        return userCreated;
    }
}

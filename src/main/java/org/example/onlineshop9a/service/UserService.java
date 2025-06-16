package org.example.onlineshop9a.service;

import org.example.onlineshop9a.dto.UserDto;
import org.example.onlineshop9a.model.Result;
import org.example.onlineshop9a.model.User;
import org.example.onlineshop9a.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class UserService {
    @Autowired  //DI
    private UserRepository userRepository;
//  get List of All Users
    public List<User> getAllUsers() {
        List<User> allUser = userRepository.findAll();
        return allUser;
    }
//  getUserbyUserId
    public User getUserById(Integer id) {
        User getUserbyID = userRepository.findById(id);
        return getUserbyID;
    }
//  method CreateUser to create new user
    public User createUser(UserDto userDto) {
        if (userDto == null || userDto.getUsername() == null || userDto.getPassword() == null) {
            throw new IllegalArgumentException("userDto is null");
        }
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        return userRepository.save(user);
    }
//  update method to update User. We use class Result to return status of method and message
    public Result updateUser(Long userId, UserDto userDto) {
        User updateduser = userRepository.findById(userId).orElse(null);
        if (updateduser == null) {
            return new Result(false, "user not found");
        }
        updateduser.setUsername(userDto.getUsername());
        updateduser.setPassword(userDto.getPassword());
        updateduser.setEmail(userDto.getEmail());
        userRepository.save(updateduser);
        return new Result(true, "User updated successfully");
    }
    public Result deleteUser(Long userId) {
        User deleteduser = userRepository.findById(userId).orElse(null);
        if (deleteduser == null) {
            return new Result(false, "user not found");
        }
        userRepository.delete(deleteduser);
        return new Result(true, "User deleted successfully");
    }

}

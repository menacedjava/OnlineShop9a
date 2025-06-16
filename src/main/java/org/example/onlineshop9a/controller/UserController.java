package org.example.onlineshop9a.controller;

import org.example.onlineshop9a.dto.UserDto;
import org.example.onlineshop9a.model.Result;
import org.example.onlineshop9a.model.User;
import org.example.onlineshop9a.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //Controller Annotation
@RequestMapping("{/api-user}") //our User-API
public class UserController {
    @Autowired  //DI
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("{/id}")
    public User getUser(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @PutMapping("{/id}")
    public Result updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        return userService.updateUser(id, userDto);
    }

    @DeleteMapping("{/id}")
    public Result deleteUser(@PathVariable Long id) {
        return userService.deleteUser(id);
    }
}

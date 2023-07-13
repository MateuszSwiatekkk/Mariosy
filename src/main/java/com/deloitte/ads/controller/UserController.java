package com.deloitte.ads.controller;

import com.deloitte.ads.entity.User;
import com.deloitte.ads.dto.UserDTO;
import com.deloitte.ads.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public Set<User> getAllUsers() {
        return userService.getUsers();
    }
    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId){
        return userService.getUserById(userId);
    }

    @PostMapping("/create")
    public void addUser(@RequestBody UserDTO user) {
        userService.createUser(user);
    }

//    @GetMapping("{userId}")
//    public User findUserById(@PathVariable long userId) {
//        return recommendations.findUserById(userId);
//    }
//
}

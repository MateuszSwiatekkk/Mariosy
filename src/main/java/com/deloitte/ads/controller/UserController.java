package com.deloitte.ads.controller;

import com.deloitte.ads.entity.User;
import com.deloitte.ads.entity.UserDTO;
import com.deloitte.ads.service.Recommendations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

//GET:all users
//POST:user
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    Recommendations recommendations;

    @GetMapping
    public Set<User> getAllUsers() {
        return recommendations.getUsers();
    }

    @GetMapping("{userId}")
    public User findUserById(@PathVariable long userId) {
        return recommendations.findUserById(userId);
    }

    @PostMapping("/create")
    public void addUser(@RequestBody UserDTO userDTO) {
        long id = 4;
        String name = userDTO.getName();
        String surname = userDTO.getSurname();
        String email = userDTO.getEmail();
        recommendations.createUser(id, name, surname, email);
    }
}

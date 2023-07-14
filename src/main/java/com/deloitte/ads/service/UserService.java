package com.deloitte.ads.service;

import com.deloitte.ads.entity.User;
import com.deloitte.ads.dto.UserDTO;
import com.deloitte.ads.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public Set<User> getUsers() {
        return new HashSet<>(userRepository
                .findAll());
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    public void createUser(UserDTO userDTO) {
//        User nextUser = new User(userDTO.getName(), userDTO.getSurname(), userDTO.getEmail());
//        userRepository.save(nextUser);
    }
}

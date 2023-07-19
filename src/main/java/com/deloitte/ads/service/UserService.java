package com.deloitte.ads.service;

import com.deloitte.ads.entity.Marios;
import com.deloitte.ads.entity.User;
import com.deloitte.ads.dto.UserDTO;
import com.deloitte.ads.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;


    public Set<User> getUsers() {
        return new HashSet<>(userRepository
                .findAll());
    }

    public User getUserById(UUID id) {
        return userRepository.findByExternalKeyUser(id);
    }

    public void createUser(UserDTO userDTO) {
        User nextUser = new User(userDTO.getName(), userDTO.getSurname(), userDTO.getEmail(),new HashSet<>(),new HashSet<>());
        userRepository.save(nextUser);
    }
}

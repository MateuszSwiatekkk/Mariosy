package com.deloitte.ads.service;

import com.deloitte.ads.dto.MariosDTO;
import com.deloitte.ads.entity.Marios;
import com.deloitte.ads.entity.User;
import com.deloitte.ads.repository.MariosRepository;
import com.deloitte.ads.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


@Service
@AllArgsConstructor
public class MariosService {
    private final MariosRepository mariosRepository;
    private final UserService userService;

    public Set<Marios> getMarios() {
        return new HashSet<>(mariosRepository.findAll());
    }

    public void createMarios(MariosDTO mariosDTO) {
        UUID senderId = mariosDTO.getExternalKeyMarios();
        User sender = userService.getUserById(senderId);

        Set<UUID> recipentIds = mariosDTO.getRecipents();
        Set<User> recipentUsers = new HashSet<>();

        for (UUID id : recipentIds) {
            recipentUsers.add(userService.getUserById(id));
        }

        Marios marios = new Marios(mariosDTO.getMariosTypes(), mariosDTO.getMessage(), recipentUsers, sender);
        mariosRepository.save(marios);
    }

    public Set<Marios> getUserCreatedMarios(UUID userId) {
        User user = userService.getUserById(userId);
        return user.getCreatedMarios();
    }

    public Set<Marios> getUserReceivedMarios(UUID userId) {
        User user = userService.getUserById(userId);
        return user.getReceivedMarios();
    }

    public void deleteMarios(UUID mariosId) {
        Marios marios = mariosRepository.findByexternalKeyMarios(mariosId);
        mariosRepository.delete(marios);
    }
}

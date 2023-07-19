package com.deloitte.ads.controller;

import com.deloitte.ads.dto.MariosDTO;
import com.deloitte.ads.entity.Marios;
import com.deloitte.ads.service.MariosService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;


@RestController
@RequestMapping("/api/marios")
@AllArgsConstructor
public class MariosController {

    private final MariosService mariosService;

    @GetMapping
    public Set<Marios> getAllMarios() {
        return mariosService.getMarios();
    }
    @GetMapping("/{userId}/createdMarios")
    public Set<Marios>getUserCreatedMarios(@PathVariable UUID userId){
        return mariosService.getUserCreatedMarios(userId);
    }
    @GetMapping("/{userId}/receivedMarios")
    public Set<Marios>getUserReceivedMarios(@PathVariable UUID userId){
        return mariosService.getUserReceivedMarios(userId);
    }
    @PostMapping("/createMarios")
    public void addMarios(@RequestBody MariosDTO mariosDTO) {
        mariosService.createMarios(mariosDTO);
    }

    @DeleteMapping("/delete/{mariosId}")
    public void deleteMarios(@PathVariable UUID mariosId){
        mariosService.deleteMarios(mariosId);
    }
//
//    @GetMapping("/sentMarios/{userId}")
//    public Set<Marios> getUserSentMarios(@PathVariable long userId) {
//        return recommendations.getSentMarios(userId);
//    }
//
//    @GetMapping("/receivedMarios/{userId}")
//    public Set<Marios> getUserReceivedMarios(@PathVariable long userId) {
//        return recommendations.getReceivedMarios(userId);
//    }
//
}

package com.deloitte.ads.controller;

import com.deloitte.ads.dto.MariosDTO;
import com.deloitte.ads.entity.Marios;
import com.deloitte.ads.service.MariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

//GET:all marios, user sent marios,user received marios //DONE
//POST:marios //DONE
@RestController
@RequestMapping("/api/marios")
public class MariosController {
    @Autowired
    private MariosService mariosService;

    @GetMapping
    public Set<Marios> getAllMarios() {
        return mariosService.getMarios();
    }
    @PostMapping("/createMarios")
    public void addMarios(@RequestBody MariosDTO mariosDTO) {
        mariosService.createMarios(mariosDTO);
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

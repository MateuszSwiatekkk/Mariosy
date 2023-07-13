package com.deloitte.ads.controller;

import com.deloitte.ads.entity.Marios;
import com.deloitte.ads.entity.MariosDTO;
import com.deloitte.ads.entity.User;
import com.deloitte.ads.service.Recommendations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

//GET:all marios, user sent marios,user received marios //DONE
//POST:marios //DONE
@RestController
@RequestMapping("/api/marios")
public class MariosController {
    @Autowired
    private Recommendations recommendations;

    @GetMapping
    public Set<Marios> getAllMarios() {
        return recommendations.getMarios();
    }

    @GetMapping("/sentMarios/{userId}")
    public Set<Marios> getUserSentMarios(@PathVariable long userId) {
        return recommendations.getSentMarios(userId);
    }

    @GetMapping("/receivedMarios/{userId}")
    public Set<Marios> getUserReceivedMarios(@PathVariable long userId) {
        return recommendations.getReceivedMarios(userId);
    }

    @PostMapping("/createMarios/{userId}")
    public void addMarios(@RequestBody MariosDTO mariosDTO) {
        long id = 4;

        User user = mariosDTO.getSender();
        List<User> recipents = mariosDTO.getRecipents();
        String msg = mariosDTO.getMessage();
        String mariosType = mariosDTO.getMariosTypes();
        recommendations.createMarios(id, mariosType, user, recipents, msg);
    }
}

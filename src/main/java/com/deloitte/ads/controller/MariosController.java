package com.deloitte.ads.controller;

import com.deloitte.ads.entity.Marios;
import com.deloitte.ads.service.Recommendations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

//GET:all marios, sent marios, received marios
//POST:marios
@RestController
@RequestMapping("/api/marios")
public class MariosController {
    @Autowired
    private Recommendations recommendations;
    @GetMapping
    public Set<Marios>getAllMarios(){
        return recommendations.getMarios();
    }
    @GetMapping("/sentMarios/{userId}")
    public Set<Marios>getUserSentMarios(@PathVariable long userId){
        return recommendations.getSentMarios(userId);
    }

}

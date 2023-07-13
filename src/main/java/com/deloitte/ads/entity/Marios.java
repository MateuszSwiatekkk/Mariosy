package com.deloitte.ads.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "marios")
public class Marios{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mariosId;
    @Column(name = "mariostype")
    private String mariosType;
    @Column(name = "senderid")
    private Long senderId;
    @Column(name = "message")
    private String message;

    public Marios(String mariosType, Long senderId, String message) {
        this.mariosType = mariosType;
        this.senderId = senderId;
        this.message = message;
    }
}

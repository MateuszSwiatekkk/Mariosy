package com.deloitte.ads.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "marios")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "mariosId")
public class Marios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mariosId;

    @Column(name = "mariostype")
    private String mariosType;

    @Column(name = "message")
    private String message;

    @ManyToMany
    @JoinTable(
            name = "mariosreceived",
            joinColumns = @JoinColumn(name = "mariosid"),
            inverseJoinColumns = @JoinColumn(name = "userid"))
    @JsonManagedReference
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "userid")
    @JsonIdentityReference(alwaysAsId = true)  //lazy/eager
    private Set<User> recipents;

    @ManyToOne
    @JoinColumn(name = "senderid")
    @JsonBackReference
    private User sender;

    public Marios(String mariosType, String message, Set<User> recipents, User sender) {
        this.mariosType = mariosType;
        this.message = message;
        this.recipents = recipents;
        this.sender = sender;
    }

}

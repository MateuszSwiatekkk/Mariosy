package com.deloitte.ads.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.List;
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
public class Marios{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mariosId;
    @Column(name = "mariostype")
    private String mariosType;
    @Column(name = "message")
    private String message;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "marios_receiver",
            joinColumns = @JoinColumn(name = "marios_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    @JsonManagedReference
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "userid")
    @JsonIdentityReference(alwaysAsId = true)
    private Set<User> receivers;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ref_creator_id")
    @JsonBackReference
    private User creator;

    public Marios(String mariosType, String message, Set<User> receivers, User creator) {
        this.mariosType = mariosType;
        this.message = message;
        this.receivers = receivers;
        this.creator = creator;
    }
}

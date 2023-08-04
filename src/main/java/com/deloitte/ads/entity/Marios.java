package com.deloitte.ads.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "marios")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "externalKeyMarios")
public class Marios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@JsonIgnore
    private Long mariosId;

    @Column(name = "externalkeymarios")
    private UUID externalKeyMarios = UUID.randomUUID();

    @Column(name = "mariostype")
    private String mariosType;

    @Column(name="title")
    private String title;

    @Column(name = "message")
    private String message;

    @ManyToMany
    @JoinTable(
            name = "mariosreceived",
            joinColumns = @JoinColumn(name = "mariosid"),
            inverseJoinColumns = @JoinColumn(name = "userid"))
    @JsonManagedReference
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "externalKeyUser")
    @JsonIdentityReference(alwaysAsId = true)
    private Set<User> recipients;

    @ManyToOne
    @JoinColumn(name = "senderid")
//    @JsonBackReference
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "externalKeyUser")
    @JsonIdentityReference(alwaysAsId = true)
    private User sender;

    public Marios(String mariosType, String title, String message, Set<User> recipients, User sender) {
        this.mariosType = mariosType;
        this.title=title;
        this.message = message;
        this.recipients = recipients;
        this.sender = sender;
    }
}

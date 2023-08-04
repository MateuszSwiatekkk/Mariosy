package com.deloitte.ads.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "externalKeyUser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;

    @Column(name = "externalkeyuser")
    private UUID externalKeyUser = UUID.randomUUID();

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @ManyToMany(mappedBy = "recipients")
    @JsonBackReference
    private Set<Marios> receivedMarios;

    @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "sender",
            cascade = {CascadeType.ALL})
    @JsonManagedReference
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "externalKeyMarios")
    @JsonIdentityReference(alwaysAsId = true)
    private Set<Marios> createdMarios;

    public User(String name, String surname, String email, Set<Marios> receivedMarios, Set<Marios> createdMarios) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.receivedMarios = receivedMarios;
        this.createdMarios = createdMarios;
    }
}

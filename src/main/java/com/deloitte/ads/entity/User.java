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
@Entity
@Table(name = "users")
@Getter
@Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "externalKeyUser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long userid;

    @Column(name="externalkeyuser")
    private UUID externalKeyUser = UUID.randomUUID();

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @ManyToMany(mappedBy = "recipents")
    @JsonBackReference
    private Set<Marios> receivedMarios;

    @OneToMany(
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

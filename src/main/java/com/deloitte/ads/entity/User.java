package com.deloitte.ads.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.checkerframework.checker.units.qual.C;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@Getter
@Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "userid")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userid;
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="email")
    private String email;
    @ManyToMany(mappedBy = "receivers")
    @JsonBackReference
    private Set<Marios> received_marioses;
    @OneToMany(
            mappedBy = "creator",
            cascade = {CascadeType.ALL})
    @JsonManagedReference
    private Set<Marios> created_marioses;

    public User(String name, String surname, String email, Set<Marios> received_marioses, Set<Marios> created_marioses) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.received_marioses = received_marioses;
        this.created_marioses = created_marioses;
    }
}

package com.deloitte.ads.entity;

import org.checkerframework.checker.units.qual.C;

import javax.persistence.*;
import java.util.List;

@Entity(name="USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="surname")
    private String surname;
    @Column(name="email")
    private String email;

    public User(long id, String name, String surname,String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public User() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

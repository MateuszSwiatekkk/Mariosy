package com.deloitte.ads.entity;

import java.util.List;

public class Marios {
    private long id;
    private MariosTypes mariostype;
    private User sender;
    private List<User> recipents;
    private String message;

    public Marios(long id, MariosTypes mariostype, User sender, List<User> recipents, String message) {
        this.id = id;
        this.mariostype = mariostype;
        this.sender = sender;
        this.recipents = recipents;
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MariosTypes getMariostype() {
        return mariostype;
    }

    public void setMariostype(MariosTypes mariostype) {
        this.mariostype = mariostype;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public List<User> getRecipents() {
        return recipents;
    }

    public void setRecipents(List<User> recipents) {
        this.recipents = recipents;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

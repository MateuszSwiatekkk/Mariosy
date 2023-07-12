package com.deloitte.ads.entity;

import java.util.List;

public class MariosDTO {
    private MariosTypes mariosTypes;
    private User sender;
    private List<User> recipents;
    private String message;


    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public MariosTypes getMariosTypes() {
        return mariosTypes;
    }

    public void setMariosTypes(MariosTypes mariosTypes) {
        this.mariosTypes = mariosTypes;
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

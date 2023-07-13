package com.deloitte.ads.service;

import com.deloitte.ads.entity.Marios;
import com.deloitte.ads.entity.User;
import com.google.common.collect.Sets;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Service

public class Recommendations {
    private Set<Marios> marios;
    private Set<User> users;

    public Recommendations(Set<Marios> marios, Set<User> users) {
        User user1 = new User(1, "Mateusz", "Swiatek", "mail1@gmail.com");
        User user2 = new User(2, "Mateusz2", "Swiatek2", "mail2@gmail.com");
        User user3 = new User(3, "Mateusz3", "Swiatek", "mail3@gmail.com");

        Marios marios1 = new Marios(1, "MARIO", user1, List.of(user2, user3), "msg1");
        Marios marios2 = new Marios(2, "KOOPA TROOPA", user2, List.of(user1), "msg2");
        Marios marios3 = new Marios(3, "WARIO", user3, List.of(user1, user2), "msg3");

        this.marios = Sets.newHashSet(marios1,marios2,marios3);
        this.users = Sets.newHashSet(user1,user2,user3);
    }

    public Set<Marios> getMarios() {
        return marios;
    }

    public Set<User> getUsers() {
        return users;
    }

    public User findUserById(long id) {
        return users.stream()
                .filter(user -> user.getId()==id).findAny().orElseThrow();
    }

    public Set<Marios> getSentMarios(long userId) {
        return marios.stream().filter(m -> m.getSender().getId()==userId).collect(Collectors.toSet());
    }

    public Set<Marios> getReceivedMarios(long userId) {
        return marios.stream()
                .filter(marios -> marios.getRecipents().stream()
                        .anyMatch(user -> user.getId()==userId))
                .collect(Collectors.toSet());
    }
    public void createMarios(long id, String mariostype, User sender, List<User> recipents, String message){
        Marios nextMarios=new Marios(id, mariostype, sender, recipents, message);
        marios.add(nextMarios);
    }
    public void createUser(long id,String name,String surname,String email){
        User nextUser=new User(id,name,surname,email);
        users.add(nextUser);
    }
}

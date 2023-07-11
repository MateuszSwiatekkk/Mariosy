package com.deloitte.ads.service;

import com.deloitte.ads.entity.Marios;
import com.deloitte.ads.entity.MariosTypes;
import com.deloitte.ads.entity.User;
import com.google.common.collect.Sets;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

        Marios marios1 = new Marios(1, MariosTypes.MARIO, user1, List.of(user2, user3), "msg1");
        Marios marios2 = new Marios(2, MariosTypes.KOOPA_TROOPA, user2, List.of(user1), "msg2");
        Marios marios3 = new Marios(3, MariosTypes.WARIO, user3, List.of(user1, user2), "msg3");

        this.marios = Sets.newHashSet(marios1,marios2,marios3);
        this.users = Sets.newHashSet(user1,user2,user3);
    }

    public Set<Marios> getMarios() {
        return marios;
    }

    public Set<String> getUsers() {
        if (users.contains(null) || users.isEmpty()) {
            return Set.of("none");
        }
        return users.stream().map(User::getSurname).collect(Collectors.toSet());
    }

    public Optional<User> findUser(String surname) {
        return users.stream()
                .filter(user -> user.getSurname().equals(surname)).findAny();
    }

    public Set<Marios> getSentMarios(long userId) {
        return marios.stream().filter(m -> m.getSender().getId()==userId).collect(Collectors.toSet());
    }

    public long getReceivedMarios(String surname) {
        return marios.stream()
                .filter(marios -> marios.getRecipents().stream()
                        .anyMatch(user -> user.getSurname().equals(surname)))
                .count();
    }

}

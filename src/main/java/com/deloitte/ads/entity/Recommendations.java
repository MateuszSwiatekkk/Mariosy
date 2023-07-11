package com.deloitte.ads.entity;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Recommendations {
    private Set<Marios> marios;
    private Set<User> users;

    public Recommendations(Set<Marios> marios, Set<User> users) {
        this.marios = marios;
        this.users = users;
    }

    public Set<String> getUsers(){
        if(users.contains(null) || users.isEmpty()) {
            return Set.of("none");
        }
        return users.stream().map(User::getSurname).collect(Collectors.toSet());
    }

    public Optional<User> findUser(String surname){
        return users.stream()
                .filter(user -> user.getSurname().equals(surname)).findAny();
    }
    public long getSentMarios(String surname){
        return marios.stream().filter(m -> m.getSender().getSurname().equals(surname)).count();
    }

    public long getReceivedMarios(String surname){
        return marios.stream()
                .filter(marios -> marios.getRecipents().stream()
                        .anyMatch(user -> user.getSurname().equals(surname)))
                .count();
    }

}

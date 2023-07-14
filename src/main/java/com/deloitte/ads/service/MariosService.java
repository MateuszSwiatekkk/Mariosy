package com.deloitte.ads.service;

import com.deloitte.ads.dto.MariosDTO;
import com.deloitte.ads.entity.Marios;
import com.deloitte.ads.entity.User;
import com.deloitte.ads.repository.MariosRepository;
import com.deloitte.ads.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;



@Service
@AllArgsConstructor
public class MariosService {
    private final MariosRepository mariosRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    public Set<Marios> getMarios() {
        return new HashSet<>(mariosRepository.findAll());
    }

    public void createMarios(MariosDTO mariosDTO) {
//        User user1=new User("name1","surname1","mail1",new HashSet<>(),new HashSet<>());
//        User user2=new User("name2","surname2","mail2",new HashSet<>(),new HashSet<>());
//        User user3=new User("name3","surname3","mail3",new HashSet<>(),new HashSet<>());

//        userRepository.save(user1);
//        userRepository.save(user2);
//        userRepository.save(user3);
        Long senderId = mariosDTO.getSenderId();
        User sender = userService.getUserById(senderId);

        Set<Long> recipentIds = mariosDTO.getRecipents();
        Set<User> recipentUsers = new HashSet<>();
        for(Long id : recipentIds){
            recipentUsers.add(userService.getUserById(id));
        }


        Marios marios = new Marios(mariosDTO.getMariosTypes(), mariosDTO.getMessage(), recipentUsers,sender);
//        Marios marios = new Marios(mariosDTO.getMariosTypes(),mariosDTO.getSenderId(),mariosDTO.getMessage());
        mariosRepository.save(marios);




    }
//    public Recommendations(Set<Marios> marios, Set<User> users) {
//    }
//
//
//    public Set<User> getUsers() {
//        return users;
//    }
//
//    public User findUserById(long id) {
//        return users.stream()
//                .filter(user -> user.getId()==id).findAny().orElseThrow();
//    }
//
//    public Set<Marios> getSentMarios(long userId) {
//        return marios.stream().filter(m -> m.getSender().getId()==userId).collect(Collectors.toSet());
//    }
//
//    public Set<Marios> getReceivedMarios(long userId) {
//        return marios.stream()
//                .filter(marios -> marios.getRecipents().stream()
//                        .anyMatch(user -> user.getId()==userId))
//                .collect(Collectors.toSet());
//    }
//    public void createMarios(long id, String mariostype, User sender, List<User> recipents, String message){
//        Marios nextMarios=new Marios(id, mariostype, sender, recipents, message);
//        marios.add(nextMarios);
//    }
//    public void createUser(long id,String name,String surname,String email){
//        User nextUser=new User(id,name,surname,email);
//        users.add(nextUser);
//    }
}

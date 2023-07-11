package com.deloitte.ads.entity;

import com.deloitte.ads.service.Recommendations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

class RecommendationsTest {
//    @InjectMocks
//    private Recommendations recommendations;
//    private Set<Marios> marios;
//    private Set<User> users;
//
//    @BeforeEach
//    void setUp() {
//        User user1 = new User(1, "Mateusz", "Swiatek","mail1@gmail.com");
//        User user2 = new User(2, "Mateusz2", "Swiatek2","mail2@gmail.com");
//
//        users = Set.of(user1, user2);
//        marios = Set.of(new Marios(1, MariosTypes.MARIO, user1, List.of(user2), "msg1"),
//                new Marios(2, MariosTypes.WARIO, user2, List.of(user1), "msg2"),
//                new Marios(3,MariosTypes.KOOPA_TROOPA,user2,List.of(user1),"msg3")
//        );
//        recommendations = new Recommendations(marios, users);
//    }
//
//    @Test
//    void getUsers() {
//        //given
//        //when
//        Set<String> surnames = recommendations.getUsers();
//        //then
//        Set<String> surnamesCorrect = Set.of("Swiatek", "Swiatek2");
//        Assertions.assertEquals(surnames, surnamesCorrect);
//    }
//    @Test
//    void getUsersWhenEmpty() {
//        //given
//        Set<User>emptyUsers=new HashSet<>();
//        Recommendations recommendationsEmpty=new Recommendations(marios,emptyUsers);
//        //when
//        Set<String> surnames = recommendationsEmpty.getUsers();
//        //then
//        Set<String> surnamesCorrect = Set.of("none");
//        Assertions.assertEquals(surnames, surnamesCorrect);
//    }
//    @Test
//    void getUsersWhenNull() {
//        //given
//        Set<User>nullUsers = new HashSet<>();
//        nullUsers.add(null);
//        Recommendations nullRecommendations = new Recommendations(marios,nullUsers);
//        //when
//        Set<String> surnames = nullRecommendations.getUsers();
//        //then
//        Set<String> surnamesCorrect = Set.of("none");
//        Assertions.assertEquals(surnames, surnamesCorrect);
//    }
//
//    @Test
//    void findUser() {
//        //given
//        String surname = "Swiatek";
//        //when
//        Optional<User>userOptional=recommendations.findUser(surname);
//        //then
//        Assertions.assertEquals(surname,userOptional.get().getSurname());
//    }
//
//    @Test
//    void getSentMarios() {
//        //given
//        String surname = "Swiatek";
//        //when
//        long mariosSentAmount=recommendations.getSentMarios(surname);
//        //then
//        Assertions.assertEquals(1,mariosSentAmount);
//    }
//
//    @Test
//    void getReceivedMarios() {
//        //given
//        String surname = "Swiatek";
//        //when
//        long mariosGivenAmount = recommendations.getReceivedMarios(surname);
//        //then
//        Assertions.assertEquals(2,mariosGivenAmount);
//
//    }
}
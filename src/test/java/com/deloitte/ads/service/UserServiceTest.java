//package com.deloitte.ads.service;
//
//import com.deloitte.ads.dto.UserDTO;
//import com.deloitte.ads.entity.User;
//import com.deloitte.ads.repository.UserRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.List;
//import java.util.Set;
//import java.util.UUID;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//@ExtendWith(MockitoExtension.class)
//public class UserServiceTest {
//    @Mock
//    private UserRepository userRepository;
//    @InjectMocks
//    private UserService userService;
//    private UserDTO testUserDTO;
//    private User testUser;
//    private User testUser2;
//    private UUID testUuid;
//    private UUID testUuid2;
//
//    @BeforeEach
//    public void setup() {
//
//        testUuid = UUID.randomUUID();
//        testUuid2 = UUID.randomUUID();
//
//        testUser = new User();
//        testUser.setExternalKeyUser(testUuid);
//        testUser.setName("Test");
//        testUser.setSurname("User");
//        testUser.setEmail("testuser@gmail.com");
//
//        testUser2 = new User();
//        testUser2.setExternalKeyUser(testUuid2);
//        testUser2.setName("Test2");
//        testUser2.setSurname("User2");
//        testUser2.setEmail("testuser2@gmail.com");
//
//        testUserDTO = new UserDTO();
//        testUserDTO.setName("Test");
//        testUserDTO.setSurname("User");
//        testUserDTO.setEmail("testuser@gmail.com");
//    }
//
//    @Test
//    public void shouldReturnUser_whenGetAllUsers() {
//        List<User> users = List.of(testUser, testUser2);
//
//        when(userRepository.findAll()).thenReturn(users);
//        Set<User> result = userService.getUsers();
//
//        assertEquals(2, result.size());
////        assertEquals(testUser.getName(), result.iterator().next().getName());
//
//    }
//
//    @Test
//    public void shouldReturnCorrectUser_whenFindByExternalKey() {
//        when(userRepository.findByExternalKeyUser(any(UUID.class))).thenReturn(testUser);
//
//        User result = userService.getUserById(testUuid);
//
//        assertEquals(testUser, result);
//        assertEquals(testUser.getUserid(), result.getUserid());
//        verify(userRepository, times(1)).findByExternalKeyUser(testUuid);
//    }
//
//    @Test
//    public void shouldSaveOnce_whenSaveUser() {
//        when(userRepository.save(any(User.class))).thenReturn(testUser);
//
//        userService.createUser(testUserDTO);
//        verify(userRepository, times(1)).save(any(User.class));
//    }
//}

package com.deloitte.ads.controller;

import com.deloitte.ads.dto.UserDTO;
import com.deloitte.ads.entity.User;
import com.deloitte.ads.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)

public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private User testUser;
    private UserDTO testUserDTO;
    private UUID testUuid;

    @BeforeEach
    public void setup() {
        testUuid = UUID.randomUUID();

        testUser = new User();
        testUser.setExternalKeyUser(testUuid);
        testUser.setName("Test");
        testUser.setSurname("User");
        testUser.setEmail("testuser@gmail.com");

        testUserDTO = new UserDTO();
        testUserDTO.setName("Test");
        testUserDTO.setSurname("User");
        testUserDTO.setEmail("testuser@gmail.com");
    }

    @Test
    public void shouldReturnAllUsers_whenGetAllUsers() throws Exception {
        when(userService.getUsers()).thenReturn(Collections.singleton(testUser));

        ResultActions result = mockMvc.perform(get("/api/users")
                .contentType(MediaType.APPLICATION_JSON));

        result.andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].externalKeyUser", CoreMatchers.is(testUser.getExternalKeyUser().toString())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", CoreMatchers.is(testUser.getName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].surname", CoreMatchers.is(testUser.getSurname())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].email", CoreMatchers.is(testUser.getEmail())));
    }


    @Test
    public void shouldReturnCorrectUser_whenFindUserByExternalKey() throws Exception {
        when(userService.getUserById(any(UUID.class))).thenReturn(testUser);

        ResultActions result = mockMvc.perform(get("/api/users/" + testUuid)
                .contentType(MediaType.APPLICATION_JSON));
        result.andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.externalKeyUser", CoreMatchers.is(testUser.getExternalKeyUser().toString())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", CoreMatchers.is(testUser.getName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.surname", CoreMatchers.is(testUser.getSurname())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email", CoreMatchers.is(testUser.getEmail())));
    }

    @Test
    public void shouldCreateUser_whenCreateUser() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        String userDtoJson = objectMapper.writeValueAsString(testUserDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/users/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userDtoJson))
                .andExpect(status().isOk());
    }
}
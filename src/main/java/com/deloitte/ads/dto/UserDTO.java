package com.deloitte.ads.dto;

import com.deloitte.ads.entity.Marios;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private String name;
    private String surname;
    private String email;
//    private Set<Marios> receivedMarios;
//    private Set<Marios> createdMarios;
}

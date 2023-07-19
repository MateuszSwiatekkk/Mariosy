package com.deloitte.ads.dto;

import com.deloitte.ads.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class MariosDTO {
    private String mariosTypes;
    private UUID externalKeyMarios;
    private Set<UUID> recipents;
    private String message;
}

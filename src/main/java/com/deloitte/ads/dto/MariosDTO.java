package com.deloitte.ads.dto;

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

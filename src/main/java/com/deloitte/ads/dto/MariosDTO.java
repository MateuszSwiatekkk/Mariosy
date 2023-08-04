package com.deloitte.ads.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class MariosDTO {
    private String mariosTypes;
    private UUID externalKeyUser;
    private Set<UUID> recipients;
    private String title;
    private String message;
}

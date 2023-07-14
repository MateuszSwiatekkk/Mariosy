package com.deloitte.ads.dto;

import com.deloitte.ads.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class MariosDTO {
    private String mariosTypes;
    private Long senderId;
    private Set<Long> recipents;
    private String message;
}

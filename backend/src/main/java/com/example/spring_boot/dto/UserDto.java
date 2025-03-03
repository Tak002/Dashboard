package com.example.spring_boot.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class UserDto {
    private final Long id;
    private final String name;
    private final String email;
}

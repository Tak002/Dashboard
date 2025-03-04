package com.example.spring_boot.dto;

import com.example.spring_boot.role.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class UserDto {
    private final Long id;
    private final String email;
    private final String password;
    private final Role role;
}

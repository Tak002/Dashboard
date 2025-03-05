package com.example.dashboard.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class LoginDto {
    private final String email;
    private final String password;
}

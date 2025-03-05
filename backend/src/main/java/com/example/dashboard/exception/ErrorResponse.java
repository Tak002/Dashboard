package com.example.dashboard.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter //getter 없을 시 ErrorResponse가 정상적으로 작동 안함
@AllArgsConstructor
public class ErrorResponse {
    String error;
    String message;
}

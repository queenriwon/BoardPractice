package com.example.boardpractice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
public class SignUpRequestDto {
    private final String username;
    private final String password;
    private final Integer age;
}

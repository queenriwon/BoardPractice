package com.example.boardpractice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardWithAgeResponseDto {
    private final String title;
    private final String contents;
    private final Integer age;
}

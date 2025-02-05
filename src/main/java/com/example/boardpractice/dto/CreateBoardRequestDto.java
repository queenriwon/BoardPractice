package com.example.boardpractice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateBoardRequestDto {
    private final String title;
    private final String contents;
    private final String username;

}

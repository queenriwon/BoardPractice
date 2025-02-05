package com.example.boardpractice.dto;

import com.example.boardpractice.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardResponseDto {
    private final Long id;
    private final String title;
    private final String contents;

    public static BoardResponseDto toDto(Board board) {
        return new BoardResponseDto(board.getId(), board.getTitle(), board.getContents());
    }

}

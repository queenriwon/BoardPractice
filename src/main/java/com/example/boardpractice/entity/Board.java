package com.example.boardpractice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Table(name = "board")
public class Board extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "longtext")  // 긴 텍스트 저장할 수 있음
    private String contents;

    @Setter
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public Board() {
    }

    public Board(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}

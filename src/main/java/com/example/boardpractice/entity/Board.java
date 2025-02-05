package com.example.boardpractice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "board")
public class Board extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "longtext")  // 긴 텍스트 저장할 수 있음
    private String contents;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}

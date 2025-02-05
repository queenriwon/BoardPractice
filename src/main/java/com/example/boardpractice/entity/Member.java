package com.example.boardpractice.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "member")
@NoArgsConstructor
public class Member extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Mysql
    private Long id;
    // @Entity는 id가 필수

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    private Integer age;


    public Member(String username, String password, Integer age) {
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public void updatePassword(String password) {
        this.password = password;
    }
}

// 실행시
/*
Hibernate:
    drop table if exists member
Hibernate:
    create table member (
        age integer,
        created_at datetime(6),
        id bigint not null auto_increment,
        modified_at datetime(6),
        password varchar(255) not null,
        username varchar(255) not null,
        primary key (id)
    ) engine=InnoDB
Hibernate:
    alter table member
       add constraint UKgc3jmn7c2abyo3wf6syln5t2i unique (username)

 */
package com.example.boardpractice.repository;


import com.example.boardpractice.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

// 확장될 가능성이 없다면 인터페이스가 아닌 구현체에 의존해도 된다.
public interface MemberRepository extends JpaRepository<Member,Long> {


    Optional<Member> findMemberByUsername(String username);

    default Member findMemberByUsernameOrElseThrow(String username) {
        return findMemberByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "찾을수없는 유저네임"));
    }


    default Member findByIdOrElseThrow(Long id) {
        return findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "id못찾음"));

    }



}


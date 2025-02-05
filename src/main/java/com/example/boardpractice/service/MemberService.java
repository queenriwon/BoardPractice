package com.example.boardpractice.service;

import com.example.boardpractice.dto.MemberResponseDto;
import com.example.boardpractice.dto.SignUpResponseDto;
import com.example.boardpractice.entity.Member;
import com.example.boardpractice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service // 변경될 여지가 있다면 인터페이스로 설계해야함
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public SignUpResponseDto signUp(String username, String password, Integer age) {

        Member member = new Member(username, password, age);

        Member savedMember = memberRepository.save(member);

        return new SignUpResponseDto(savedMember.getId(), savedMember.getUsername(), savedMember.getAge());
    }

    public MemberResponseDto findById(Long id) {
        Optional<Member> optionalMember = memberRepository.findById(id);

        if (optionalMember.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "id 없음"); // 204: No Contents
        }

        Member findMember = optionalMember.get();

        return new MemberResponseDto(findMember.getUsername(), findMember.getAge());
    }


    @Transactional
    public void updatePassword(Long id, String oldPassword, String newPassword) {
        Member findMember = memberRepository.findByIdOrElseThrow(id);

        if (!findMember.getPassword().equals(oldPassword)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호 불일치");
        }

        findMember.updatePassword(newPassword);  // 자동으로 업데이트됨


    }
}

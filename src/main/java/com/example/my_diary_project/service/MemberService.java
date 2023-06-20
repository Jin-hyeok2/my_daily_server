package com.example.my_diary_project.service;

import com.example.my_diary_project.dto.response.member.MemberInfoResponse;
import com.example.my_diary_project.entity.Member;
import com.example.my_diary_project.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberInfoResponse getMemberInfo(Long id) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new RuntimeException("temp error"));

        return MemberInfoResponse.fromEntity(member);
    }
}

package com.example.my_diary_project.service;

import com.example.my_diary_project.dto.request.CreateMemberRequest;
import com.example.my_diary_project.dto.response.member.MemberProxy;
import com.example.my_diary_project.entity.Member;
import com.example.my_diary_project.repository.member.MemberRepository;
import com.example.my_diary_project.status.Gender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;

  public MemberProxy getMemberInfo(Long id) {
    return MemberProxy.fromEntity(
        memberRepository.findById(id).orElseThrow(() -> new RuntimeException("temp error")));
  }

  public MemberProxy createMember(CreateMemberRequest request) {
    Member created = memberRepository.save(Member.builder()
        .name(request.getName())
        .birth(request.getBirth())
        .phone(request.getPhoneNumber())
        .gender(Gender.getGender(request.getGender()))
        .build());

    return MemberProxy.fromEntity(created);
  }
}

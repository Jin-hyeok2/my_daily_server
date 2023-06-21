package com.example.my_diary_project.dto.response.member;

import com.example.my_diary_project.entity.Member;
import lombok.Builder;

@Builder
public class MemberProxy {

  private String name;
  private String birth;
  private String phone;
  private String gender;

  public static MemberProxy fromEntity(Member member) {
    return MemberProxy.builder()
        .name(member.getName())
        .birth(member.getBirth())
        .phone(member.getPhone())
        .gender(member.getGender().getMean())
        .build();
  }
}

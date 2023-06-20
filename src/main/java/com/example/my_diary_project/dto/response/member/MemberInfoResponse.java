package com.example.my_diary_project.dto.response.member;


import com.example.my_diary_project.entity.Member;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public class MemberInfoResponse {
    @NotNull
    public Long id;

    public static MemberInfoResponse fromEntity(Member member) {
        return MemberInfoResponse.builder().id(member.getId()).build();
    }
}

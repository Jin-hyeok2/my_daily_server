package com.example.my_diary_project.controller;

import com.example.my_diary_project.dto.response.CustomResponse;
import com.example.my_diary_project.dto.response.member.MemberInfoResponse;
import com.example.my_diary_project.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/{id}")
    public CustomResponse<MemberInfoResponse> getUserInfo(@PathVariable Long id) {
        return CustomResponse.get("good~", memberService.getMemberInfo(id));
    }
}

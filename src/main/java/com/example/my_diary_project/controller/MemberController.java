package com.example.my_diary_project.controller;

import com.example.my_diary_project.dto.request.CreateMemberRequest;
import com.example.my_diary_project.dto.response.CustomResponse;
import com.example.my_diary_project.dto.response.member.MemberProxy;
import com.example.my_diary_project.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

  private final MemberService memberService;

  @PostMapping
  public CustomResponse<MemberProxy> createMember(@RequestBody @Valid CreateMemberRequest request) {
    return CustomResponse.post("message", memberService.createMember(request));
  }

  @GetMapping("/{id}")
  public CustomResponse<MemberProxy> getMemberInfo(@PathVariable Long id) {
    return CustomResponse.get("good~", memberService.getMemberInfo(id));
  }
}

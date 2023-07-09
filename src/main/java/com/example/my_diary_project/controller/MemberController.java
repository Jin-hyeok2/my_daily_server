package com.example.my_diary_project.controller;

import com.example.my_diary_project.dto.request.MemberCreateRequest;
import com.example.my_diary_project.dto.request.MemberUpdateRequest;
import com.example.my_diary_project.dto.response.CustomResponse;
import com.example.my_diary_project.service.MemberService;
import jakarta.validation.Valid;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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

    @GetMapping("/{id}")
    public CustomResponse findById(@PathVariable UUID id) {
        return CustomResponse.get("good~", memberService.getInfo(id));
    }

    @PostMapping
    public CustomResponse create(@RequestBody @Valid MemberCreateRequest request) {
        return CustomResponse.post("message", memberService.create(request));
    }

    @PatchMapping
    public CustomResponse update(@RequestBody @Valid MemberUpdateRequest request) {
        return CustomResponse.post("잘 바꿨어유", memberService.update(request));
    }

    @DeleteMapping("{id}")
    public CustomResponse delete(@PathVariable UUID id) {
        memberService.delete(id);
        return CustomResponse.delete("잘 지웠어유");
    }

}

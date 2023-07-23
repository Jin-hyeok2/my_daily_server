package com.example.my_diary_project.controller;

import com.example.my_diary_project.dto.request.MemberCreateRequest;
import com.example.my_diary_project.dto.request.MemberUpdateRequest;
import com.example.my_diary_project.dto.response.CustomResponse;
import com.example.my_diary_project.service.MemberService;
import com.example.my_diary_project.service.ProfileService;
import com.example.my_diary_project.status.Gender;
import com.example.my_diary_project.status.SignUpFrom;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final ProfileService profileService;

    @GetMapping("/{id}")
    public CustomResponse findById(@PathVariable UUID id) {
        return CustomResponse.get(memberService.getInfo(id));
    }

    @GetMapping
    public CustomResponse findAll(
        @RequestParam(required = false) UUID[] id,
        @RequestParam(required = false) Gender[] gender,
        @RequestParam(required = false) SignUpFrom[] signUpFroms) {
        return CustomResponse.get(memberService.findAll(id, gender, signUpFroms));
    }

    @PostMapping
    public CustomResponse create(@RequestBody @Valid MemberCreateRequest request) {
        return CustomResponse.post(memberService.create(request));
    }

    @PatchMapping
    public CustomResponse update(@RequestBody @Valid MemberUpdateRequest request) {
        return CustomResponse.post( memberService.update(request));
    }

    @DeleteMapping("{id}")
    public CustomResponse delete(@PathVariable UUID id) {
        memberService.delete(id);
        return CustomResponse.delete();
    }

}

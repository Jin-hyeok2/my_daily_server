package com.example.my_diary_project.controller;

import com.example.my_diary_project.dto.request.ProfileCreateRequest;
import com.example.my_diary_project.dto.request.ProfileQueryRequest;
import com.example.my_diary_project.dto.response.CustomResponse;
import com.example.my_diary_project.service.ProfileService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/profile")
public class ProfileController {

    private final ProfileService profileService;

    @GetMapping("/{id}")
    public CustomResponse findById(@PathVariable UUID id) {
        return CustomResponse.get(profileService.findById(id));
    }

    @GetMapping
    public CustomResponse findAll(@ModelAttribute ProfileQueryRequest request) {
        return CustomResponse.get(profileService.findAll(
            request.getIds(), request.getMemberIds(), request.getIsOriginProfile()));
    }

    @PostMapping
    public CustomResponse create(@RequestBody @Validated ProfileCreateRequest request) {
        return CustomResponse.post(profileService.create(request));
    }
}

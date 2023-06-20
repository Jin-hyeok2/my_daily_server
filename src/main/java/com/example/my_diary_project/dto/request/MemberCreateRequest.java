package com.example.my_diary_project.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
public class MemberCreateRequest {
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String name;
    private String imagePath;
    private String phoneNumber;
}

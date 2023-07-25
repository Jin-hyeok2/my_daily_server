package com.example.my_diary_project.status;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
    ROLE_ADMIN("관리자"), ROLE_MEMBER("일반사용자"), ROLE_MANAGER("매니저");

    private final String description;

}

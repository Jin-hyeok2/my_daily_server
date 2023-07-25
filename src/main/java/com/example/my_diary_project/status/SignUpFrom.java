package com.example.my_diary_project.status;

import java.util.Arrays;
import lombok.Getter;

@Getter
public enum SignUpFrom {
    SOCIAL_SPLIT, KAKAO, GOOGLE;

    public static SignUpFrom find(String string) {
        return Arrays.stream(SignUpFrom.values())
            .filter(signUpFrom -> string.equalsIgnoreCase(signUpFrom.name()))
            .findFirst().orElseThrow(() -> new RuntimeException("가입 경로 오류"));
    }
}

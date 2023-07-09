package com.example.my_diary_project.status;

import io.micrometer.common.util.StringUtils;
import java.util.Arrays;
import lombok.Getter;

@Getter
public enum Gender {
    MALE,
    FEMALE;

    public static Gender getGender(String target) {
        if (StringUtils.isEmpty(target)) {
            return null;
        }
        return Arrays.stream(Gender.values())
            .filter(gender -> target.equalsIgnoreCase(gender.toString())).findFirst()
            .orElseThrow(() -> new RuntimeException("규정되지 않은 성별입니다."));
    }
}



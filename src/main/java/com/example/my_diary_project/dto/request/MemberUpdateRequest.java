package com.example.my_diary_project.dto.request;

import jakarta.validation.constraints.Pattern;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberUpdateRequest {

    private UUID id;
    private String nextPassword;
    private String curPassword;
    @Pattern(regexp = "^01(?:0|1|[6-9])-(?:[0-9]{3}|[0-9]{4})-[0-9]{4}$")
    private String phone;
    private String gender;
}

package com.example.my_diary_project.dto.request;

import java.util.UUID;
import lombok.Getter;

@Getter
public class ProfileQueryRequest {
    UUID[] ids;
    UUID[] memberIds;
    Boolean isOriginProfile;
}

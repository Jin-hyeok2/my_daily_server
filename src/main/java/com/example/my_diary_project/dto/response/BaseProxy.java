package com.example.my_diary_project.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BaseProxy {

    private UUID id;
    private LocalDateTime createdOn;
    private LocalDateTime updateOn;
}

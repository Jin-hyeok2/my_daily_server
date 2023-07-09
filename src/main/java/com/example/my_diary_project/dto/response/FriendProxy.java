package com.example.my_diary_project.dto.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PRIVATE)
public class FriendProxy extends BaseProxy{
    private ProfileProxy profile;
    private MemberProxy friend;

}

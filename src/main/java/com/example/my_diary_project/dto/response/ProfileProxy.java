package com.example.my_diary_project.dto.response;

import com.example.my_diary_project.entity.Friend;
import com.example.my_diary_project.entity.Profile;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PACKAGE)
public class ProfileProxy extends BaseProxy {

    private MemberProxy member;
    private boolean isOriginProfile;
    private List<MemberProxy> friendList;

    public static ProfileProxy fromEntity(Profile entity) {
        return ProfileProxy.builder()
            .member(MemberProxy.fromEntity(entity.getMember()))
            .isOriginProfile(entity.isOriginProfile())
            .friendList(entity.getFriendList().stream()
                .map(Friend::getFriend)
                .map(MemberProxy::fromEntity)
                .collect(Collectors.toList()))
            .build();
    }
}

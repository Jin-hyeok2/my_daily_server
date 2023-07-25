package com.example.my_diary_project.dto.response;

import com.example.my_diary_project.entity.MemberProfile;
import com.example.my_diary_project.entity.Profile;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder(access = AccessLevel.PACKAGE)
public class ProfileProxy extends BaseProxy {

    private Boolean isOriginProfile;
    private String name;
    private List<MemberProxy> friendList;

    public static ProfileProxy fromEntity(Profile entity) {
        return ProfileProxy.builder()
            .isOriginProfile(entity.getIsOriginProfile())
            .friendList(entity.getProfileFriendList().stream()
                .map(MemberProfile::getFriend)
                .map(MemberProxy::fromEntity)
                .collect(Collectors.toList()))
            .build();
    }
}

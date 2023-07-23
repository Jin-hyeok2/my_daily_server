package com.example.my_diary_project.repository.Profile;

import com.example.my_diary_project.entity.QProfile;
import com.querydsl.core.types.dsl.BooleanExpression;
import java.util.UUID;

public class ProfileQueryExpression {

    public static BooleanExpression inId(UUID... ids) {
        return (ids == null || ids.length == 0) ? null
            : QProfile.profile.id.in(ids);
    }

    public static BooleanExpression inMemberId(UUID... memberIds) {
        return (memberIds == null || memberIds.length == 0) ? null
            : QProfile.profile.member.id.in(memberIds);
    }

    public static BooleanExpression eqIsOriginProfile(Boolean isOriginProfile) {
        return (isOriginProfile == null) ? null
            : QProfile.profile.isOriginProfile.eq(isOriginProfile);
    }

}

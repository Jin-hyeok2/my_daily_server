package com.example.my_diary_project.repository.Profile;

import com.example.my_diary_project.entity.QProfile;
import com.querydsl.core.types.dsl.BooleanExpression;
import java.util.UUID;

public class ProfileQueryExpression {

    public static BooleanExpression id(UUID... ids) {
        return ids.length == 0 ? null : QProfile.profile.id.in(ids);
    }

    public static BooleanExpression memberId(UUID... memberIds) {
        return memberIds.length == 0 ? null : QProfile.profile.member.id.in(memberIds);
    }

}

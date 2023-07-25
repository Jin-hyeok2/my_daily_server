package com.example.my_diary_project.repository.member;

import com.example.my_diary_project.entity.QMember;
import com.example.my_diary_project.status.Gender;
import com.example.my_diary_project.status.SignUpFrom;
import com.querydsl.core.types.dsl.BooleanExpression;
import java.util.UUID;

public class MemberQueryExpression {

    public static BooleanExpression id(UUID[] ids) {
        return (ids == null || ids.length == 0) ? null
            : QMember.member.id.in(ids);
    }

    public static BooleanExpression email(String... emails) {
        return (emails == null || emails.length == 0) ? null
            : QMember.member.email.in(emails);
    }

    public static BooleanExpression signUpFrom(SignUpFrom... signUpFroms) {
        return (signUpFroms == null || signUpFroms.length == 0) ? null
            : QMember.member.signUpFrom.in(signUpFroms);
    }

    public static BooleanExpression gender(Gender... genders) {
        return (genders == null || genders.length == 0) ? null
            : QMember.member.gender.in(genders);
    }
}

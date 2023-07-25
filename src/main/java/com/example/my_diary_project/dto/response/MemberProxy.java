package com.example.my_diary_project.dto.response;

import com.example.my_diary_project.entity.Member;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class MemberProxy extends BaseProxy {

    private String email;
    private String name;
    private String birth;
    private String phone;
    private String gender;
    private String signUpFrom;

    private MemberProxy(Member entity) {
        super(entity.getId(), entity.getCreatedOn(), entity.getUpdatedOn());
        this.email = entity.getEmail();
        this.name = entity.getName();
        this.birth = entity.getBirth();
        this.phone = entity.getPhone();
        this.gender = entity.getGender().toString();
        this.signUpFrom = entity.getSignUpFrom().toString();
    }

    public static MemberProxy fromEntity(Member member) {
        return new MemberProxy(member);
    }
}

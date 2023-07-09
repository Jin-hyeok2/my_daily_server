package com.example.my_diary_project.repository.Profile;

import com.example.my_diary_project.entity.Profile;
import com.example.my_diary_project.entity.QProfile;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProfileQueryRepository {
    private final JPAQueryFactory jpaQueryFactory;

    public Profile findByOne(BooleanExpression... expressions) {
        return jpaQueryFactory.selectFrom(QProfile.profile)
            .where(expressions)
            .fetchOne();
    }

    public List<Profile> findAll(BooleanExpression... expressions) {
        return jpaQueryFactory.selectFrom(QProfile.profile)
            .where(expressions)
            .fetch();
    }

}

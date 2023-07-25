package com.example.my_diary_project.repository.member;

import com.example.my_diary_project.entity.Member;
import com.example.my_diary_project.entity.QMember;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public Optional<Member> findById(UUID id) {
        return Optional.ofNullable(
            jpaQueryFactory.selectFrom(QMember.member)
                .where(QMember.member.id.eq(id))
                .fetchOne());

    }

    public Optional<Member> findOne(BooleanExpression... expressions) {
        return Optional.ofNullable(jpaQueryFactory.selectFrom(QMember.member)
            .where(expressions)
            .fetchOne());
    }

    public List<Member> findAll(BooleanExpression... expressions) {
        return jpaQueryFactory.selectFrom(QMember.member)
            .where(expressions)
            .fetch();
    }
}

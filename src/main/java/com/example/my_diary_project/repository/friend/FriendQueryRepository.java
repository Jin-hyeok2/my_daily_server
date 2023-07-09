package com.example.my_diary_project.repository.friend;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class FriendQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;
}

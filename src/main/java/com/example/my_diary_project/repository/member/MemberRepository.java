package com.example.my_diary_project.repository.member;

import com.example.my_diary_project.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}

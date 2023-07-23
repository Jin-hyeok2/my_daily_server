package com.example.my_diary_project.repository.friend;

import com.example.my_diary_project.entity.MemberProfile;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FriendCommandRepository extends JpaRepository<MemberProfile, UUID> {

}

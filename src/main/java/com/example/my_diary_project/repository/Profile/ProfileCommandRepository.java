package com.example.my_diary_project.repository.Profile;

import com.example.my_diary_project.entity.Profile;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileCommandRepository extends JpaRepository<Profile, UUID> {

}

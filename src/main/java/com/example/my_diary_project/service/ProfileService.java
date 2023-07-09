package com.example.my_diary_project.service;

import com.example.my_diary_project.dto.response.ProfileProxy;
import com.example.my_diary_project.repository.Profile.ProfileCommandRepository;
import com.example.my_diary_project.repository.Profile.ProfileQueryRepository;
import com.example.my_diary_project.repository.member.MemberQueryRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final MemberQueryRepository memberQueryRepository;
    private final ProfileQueryRepository profileQueryRepository;
    private final ProfileCommandRepository profileCommandRepository;

    public List<ProfileProxy> findAll() {
        return null;
    }

}

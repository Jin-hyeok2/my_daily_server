package com.example.my_diary_project.service;

import com.example.my_diary_project.dto.request.ProfileCreateRequest;
import com.example.my_diary_project.dto.response.ProfileProxy;
import com.example.my_diary_project.entity.Profile;
import com.example.my_diary_project.repository.Profile.ProfileCommandRepository;
import com.example.my_diary_project.repository.Profile.ProfileQueryExpression;
import com.example.my_diary_project.repository.Profile.ProfileQueryRepository;
import com.example.my_diary_project.repository.member.MemberQueryRepository;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final MemberQueryRepository memberQueryRepository;
    private final ProfileQueryRepository profileQueryRepository;
    private final ProfileCommandRepository profileCommandRepository;

    public ProfileProxy findById(UUID id) {
        return ProfileProxy.fromEntity(
            profileQueryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("temp")));
    }

    public List<ProfileProxy> findAll(UUID[] id, UUID[] memberId, Boolean isOriginProfile) {
        return profileQueryRepository.findAll(
                ProfileQueryExpression.inId(id),
                ProfileQueryExpression.inMemberId(memberId),
                ProfileQueryExpression.eqIsOriginProfile(isOriginProfile)
            ).stream()
            .map(ProfileProxy::fromEntity)
            .toList();
    }

    public ProfileProxy create(ProfileCreateRequest request) {
        UUID tempMemberId = UUID.randomUUID();
        return ProfileProxy.fromEntity(profileCommandRepository.save(
            Profile.builder()
                .isOriginProfile(profileQueryRepository.findByOne(
                    ProfileQueryExpression.inMemberId(tempMemberId)).isEmpty())
                .imgPath(request.getImgPath())
                .member(memberQueryRepository.findById(tempMemberId).orElseThrow())
                .build()));
    }
}

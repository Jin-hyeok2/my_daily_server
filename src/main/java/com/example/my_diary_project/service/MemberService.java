package com.example.my_diary_project.service;

import com.example.my_diary_project.dto.request.MemberCreateRequest;
import com.example.my_diary_project.dto.request.MemberUpdateRequest;
import com.example.my_diary_project.dto.response.MemberProxy;
import com.example.my_diary_project.entity.Member;
import com.example.my_diary_project.repository.member.MemberCommandRepository;
import com.example.my_diary_project.repository.member.MemberQueryExpression;
import com.example.my_diary_project.repository.member.MemberQueryRepository;
import com.example.my_diary_project.status.Gender;
import com.example.my_diary_project.status.SignUpFrom;
import io.micrometer.common.util.StringUtils;
import jakarta.transaction.Transactional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberQueryRepository memberQueryRepository;
    private final MemberCommandRepository memberCommandRepository;
    private final PasswordEncoder passwordEncoder;

    public MemberProxy getInfo(UUID id) {
        return MemberProxy.fromEntity(
            memberQueryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("temp error")));
    }

    public MemberProxy create(MemberCreateRequest request) {
        if (memberQueryRepository.findOne(
                MemberQueryExpression.email(request.getEmail()),
                MemberQueryExpression.signUpFrom(SignUpFrom.find(request.getSignUpFrom()))
            )
            .isPresent()) {
            throw new RuntimeException("이미 가입한 회원이 있습니다");
        }
        Member created = memberCommandRepository.save(Member.builder()
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .name(request.getName())
            .birth(request.getBirth())
            .phone(request.getPhoneNumber())
            .gender(Gender.getGender(request.getGender()))
            .signUpFrom(SignUpFrom.find(request.getSignUpFrom()))
            .build());

        return MemberProxy.fromEntity(created);
    }

    public MemberProxy update(MemberUpdateRequest request) {
        Member updateTarget = memberQueryRepository.findById(request.getId())
            .orElseThrow(() -> new RuntimeException("그런 사람 또 없습니다~"));
        if (StringUtils.isNotEmpty(request.getNextPassword())) {
            exchangePassword(updateTarget, request);
        }
        updateTarget.setPhone(request.getPhone());
        updateTarget.setGender(Gender.getGender(request.getGender()));

        return MemberProxy.fromEntity(updateTarget);
    }

    public void delete(UUID id) {
        memberCommandRepository.deleteById(id);
    }

    private void exchangePassword(Member updateTarget, MemberUpdateRequest request) {
        if (passwordEncoder.matches(request.getCurPassword(), updateTarget.getPassword())) {
            updateTarget.setPassword(passwordEncoder.encode(request.getNextPassword()));
        }
    }
}

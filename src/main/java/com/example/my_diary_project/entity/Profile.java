package com.example.my_diary_project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "profiles")
@DynamicUpdate
@SQLDelete(sql = "UPDATE member set is_deleted = true WHERE id = ?")
@Where(clause = "is_deleted = false")
public class Profile extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private Boolean isOriginProfile;
    private String name;
    private String imgPath;

    @ManyToOne
    @JoinColumn(name = "member_id")
    @Fetch(FetchMode.JOIN)
    private Member member;

    @OneToMany(mappedBy = "profile")
    @Builder.Default
    private List<MemberProfile> profileFriendList = new ArrayList<>();

    public void addFriend(MemberProfile... memberProfiles) {
        profileFriendList.addAll(List.of(memberProfiles));
    }
}

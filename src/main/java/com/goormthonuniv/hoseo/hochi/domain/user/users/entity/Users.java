package com.goormthonuniv.hoseo.hochi.domain.user.users.entity;

import com.goormthonuniv.hoseo.hochi.domain.user.users.entity.enums.OauthType;
import com.goormthonuniv.hoseo.hochi.domain.user.users.entity.enums.UserRole;
import com.goormthonuniv.hoseo.hochi.global.entity.TimeRecordedEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor //Jpa 사용시 무조건 필요합니당 궁금하면 찾아보슈
public class Users extends TimeRecordedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    @Column( unique = true, nullable = false )
    private String nickname;

    @Enumerated(EnumType.STRING)
    private UserRole role;    // 예: USER

    @Enumerated(EnumType.STRING)
    private OauthType oauth;    // 예: OAUTH_KAKAO

    private String oauthId;


    public void updateRole(UserRole role){
        this.role = role;
    }

    public void updateNickname(String nickname){
        this.nickname = nickname;
    }

    public void deleted(){
        markDeleted();
    }

    @Builder
    public Users(String nickname, String email, UserRole userRole, OauthType oauth, String oauthId ) {
        this.nickname = nickname;
        this.email = email;
        this.role = userRole;
        this.oauth = oauth;
        this.oauthId = oauthId;
    }

}

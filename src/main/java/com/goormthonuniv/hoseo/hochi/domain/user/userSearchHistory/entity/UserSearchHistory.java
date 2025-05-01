package com.goormthonuniv.hoseo.hochi.domain.user.userSearchHistory.entity;

import com.goormthonuniv.hoseo.hochi.global.entity.TimeRecordedEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserSearchHistory extends TimeRecordedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long routeId;


}

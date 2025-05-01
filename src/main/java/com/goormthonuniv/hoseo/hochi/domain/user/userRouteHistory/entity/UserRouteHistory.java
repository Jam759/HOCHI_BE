package com.goormthonuniv.hoseo.hochi.domain.user.userRouteHistory.entity;

import com.goormthonuniv.hoseo.hochi.global.entity.TimeRecordedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserRouteHistory extends TimeRecordedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long routeHistoryId;

}

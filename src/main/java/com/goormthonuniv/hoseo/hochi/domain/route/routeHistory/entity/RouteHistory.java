package com.goormthonuniv.hoseo.hochi.domain.route.routeHistory.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RouteHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long startLocationId;

    @Column(nullable = false)
    private Long endLocationId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String pathJson;

    private boolean isStairs;

    private boolean isSlope;

    private boolean isIndoor;

}

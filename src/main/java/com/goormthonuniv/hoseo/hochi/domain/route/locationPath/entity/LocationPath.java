package com.goormthonuniv.hoseo.hochi.domain.route.locationPath.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class LocationPath {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long startLocationId;

    @Column(nullable = false)
    private Long endLocationId;

    @Column(nullable = false)
    private double distance;

    @Column(nullable = false)
    private boolean isStairs;

    @Column(nullable = false)
    private boolean isSlope;

    @Column(nullable = false)
    private boolean isIndoor;

}

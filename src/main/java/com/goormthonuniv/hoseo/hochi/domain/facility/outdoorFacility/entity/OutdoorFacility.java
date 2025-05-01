package com.goormthonuniv.hoseo.hochi.domain.facility.outdoorFacility.entity;

import com.goormthonuniv.hoseo.hochi.domain.facility.outdoorFacility.entity.enums.OutdoorFacilityType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OutdoorFacility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private double longitude;

    @Column(nullable = false)
    private OutdoorFacilityType outdoorFacilityType;

    private String description;

    @Column(nullable = false)
    private Long iconImgId;
}

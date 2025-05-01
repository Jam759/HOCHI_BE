package com.goormthonuniv.hoseo.hochi.domain.facility.indoorFacility.entity;


import com.goormthonuniv.hoseo.hochi.domain.facility.indoorFacility.entity.enums.IndoorFacilityType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class IndoorFacility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(nullable = false)
    private double latitude;

    @Column(nullable = false)
    private double longitude;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private IndoorFacilityType indoorFacilityType;

    private String description;

    @Column(nullable = false)
    private Long iconImgId;

}

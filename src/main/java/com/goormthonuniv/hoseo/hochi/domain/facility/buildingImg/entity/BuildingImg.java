package com.goormthonuniv.hoseo.hochi.domain.facility.buildingImg.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BuildingImg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //빌딩과 1:1
    @Column(nullable = false)
    private Long building_id;

    @Column(length = 20)
    private String name;

    @Column(nullable = false)
    private String path;


}

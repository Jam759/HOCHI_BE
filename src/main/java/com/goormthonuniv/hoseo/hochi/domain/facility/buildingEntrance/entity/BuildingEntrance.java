package com.goormthonuniv.hoseo.hochi.domain.facility.buildingEntrance.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BuildingEntrance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //빌딩과 1:N 관계 (N임)
    @Column(nullable = false)
    private Long buildingId;

    //로케이션과 1:1 관계
    @Column(nullable = false)
    private Long locationId;

    //이미지와 1:N 관계 (N임)
    private Long iconImgId;

}

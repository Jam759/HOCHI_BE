package com.goormthonuniv.hoseo.hochi.domain.facility.building.entity;

import com.goormthonuniv.hoseo.hochi.domain.facility.building.entity.enums.BuildingType;
import com.goormthonuniv.hoseo.hochi.domain.facility.buildingImg.entity.BuildingImg;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double latitude;

    private double longitude;

    @Enumerated(EnumType.STRING)
    private BuildingType buildingType;

    //BuildingImg와 1:1관계
    private Long buildingImgId;
    
    //아이콘이미지와 1:1 관계
    private Long iconImgId;

}

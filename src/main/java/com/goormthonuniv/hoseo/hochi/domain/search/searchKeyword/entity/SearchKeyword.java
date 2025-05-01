package com.goormthonuniv.hoseo.hochi.domain.search.searchKeyword.entity;

import com.goormthonuniv.hoseo.hochi.domain.search.searchKeyword.entity.enums.FacilityStatus;
import com.goormthonuniv.hoseo.hochi.global.entity.TimeRecordedEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SearchKeyword extends TimeRecordedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String keyword;

    @Column(nullable = false)
    private Long refId;

    //검색 분기점 이거 통해서 각 테이블 조회하면 됨
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FacilityStatus facilityStatus;

}

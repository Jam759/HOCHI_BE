package com.goormthonuniv.hoseo.hochi.domain.favorite.userFavoritePlace.entity;

import com.goormthonuniv.hoseo.hochi.domain.search.searchKeyword.entity.enums.FacilityStatus;
import com.goormthonuniv.hoseo.hochi.global.entity.TimeRecordedEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserFavoritePlace extends TimeRecordedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long referenceId;

    // SearchKeyword에 있슴
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FacilityStatus facilityStatus;

}

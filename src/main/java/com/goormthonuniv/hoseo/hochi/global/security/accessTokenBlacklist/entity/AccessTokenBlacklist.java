package com.goormthonuniv.hoseo.hochi.global.security.accessTokenBlacklist.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccessTokenBlacklist {

    @Id
    @Column(columnDefinition = "TEXT")
    private String jti;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String accessToken;

    private LocalDateTime expiredAt;

}

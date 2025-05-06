package com.goormthonuniv.hoseo.hochi.global.security.refreshToken.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)//unique걸것!
    private Long userId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String refreshToken;

    private LocalDateTime createdAt;


    public void updateRefreshToken(String refreshToken){
        this.refreshToken = refreshToken;
        createdAt = LocalDateTime.now();
    }

}

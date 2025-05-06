package com.goormthonuniv.hoseo.hochi.global.security.refreshToken.repository;

import com.goormthonuniv.hoseo.hochi.global.security.refreshToken.entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {

    Optional<RefreshToken> findByUserId(Long userId);

}

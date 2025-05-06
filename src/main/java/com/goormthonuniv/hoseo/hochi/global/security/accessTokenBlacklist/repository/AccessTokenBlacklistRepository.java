package com.goormthonuniv.hoseo.hochi.global.security.accessTokenBlacklist.repository;

import com.goormthonuniv.hoseo.hochi.global.security.accessTokenBlacklist.entity.AccessTokenBlacklist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessTokenBlacklistRepository extends JpaRepository<AccessTokenBlacklist, String> {
}

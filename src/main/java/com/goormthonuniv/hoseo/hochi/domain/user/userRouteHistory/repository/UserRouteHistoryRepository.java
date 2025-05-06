package com.goormthonuniv.hoseo.hochi.domain.user.userRouteHistory.repository;

import com.goormthonuniv.hoseo.hochi.domain.user.userRouteHistory.entity.UserRouteHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRouteHistoryRepository extends JpaRepository<UserRouteHistory, Long> {
    List<UserRouteHistory> findByUserId(Long userId);

    List<UserRouteHistory> findByRouteHistoryId(Long RouteId);
}

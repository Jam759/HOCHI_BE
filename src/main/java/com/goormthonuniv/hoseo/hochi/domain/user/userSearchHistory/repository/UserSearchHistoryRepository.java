package com.goormthonuniv.hoseo.hochi.domain.user.userSearchHistory.repository;

import com.goormthonuniv.hoseo.hochi.domain.user.userSearchHistory.entity.UserSearchHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserSearchHistoryRepository extends JpaRepository<UserSearchHistory, Long> {

    List<UserSearchHistory> findByUserId(Long userId);

    List<UserSearchHistory> findBySearchKeywordId(Long searchKeywordId);

}

package com.goormthonuniv.hoseo.hochi.domain.user.userSearchHistory.service;

import com.goormthonuniv.hoseo.hochi.domain.user.userSearchHistory.entity.UserSearchHistory;
import com.goormthonuniv.hoseo.hochi.domain.user.userSearchHistory.exception.SearchHistoryDuplicateException;
import com.goormthonuniv.hoseo.hochi.domain.user.userSearchHistory.exception.SearchHistoryNotFoundException;
import com.goormthonuniv.hoseo.hochi.domain.user.userSearchHistory.repository.UserSearchHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.goormthonuniv.hoseo.hochi.global.util.GlobalCrudUtil.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserSearchHistoryCrudService {

    private final UserSearchHistoryRepository repository;

    public List<UserSearchHistory> findByUserId(Long userId) {
        return findListByOneField(repository::findByUserId, userId,
                () -> new SearchHistoryNotFoundException("userId : " + userId));
    }

    public List<UserSearchHistory> findBySearchKeywordId(Long searchKeywordId) {
        return findListByOneField(repository::findBySearchKeywordId, searchKeywordId,
                () -> new SearchHistoryNotFoundException("searchKeywordId : " + searchKeywordId));
    }


    @Transactional
    public void save(UserSearchHistory entity) {
        saveEntity(repository, entity,
                () -> new SearchHistoryDuplicateException("중복된 값 저장 DB제약 확인(Unique Or Not Null)"));
    }


    @Transactional
    public void deleteById(Long id) {
        deleteByField(repository::findById, id,
                () -> new SearchHistoryNotFoundException("id : " + id), repository);
    }



}

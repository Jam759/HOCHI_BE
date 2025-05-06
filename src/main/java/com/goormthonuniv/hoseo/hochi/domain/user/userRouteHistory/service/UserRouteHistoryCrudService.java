package com.goormthonuniv.hoseo.hochi.domain.user.userRouteHistory.service;

import com.goormthonuniv.hoseo.hochi.domain.user.userRouteHistory.entity.UserRouteHistory;
import com.goormthonuniv.hoseo.hochi.domain.user.userRouteHistory.exception.UserRouteHistoryDuplicateException;
import com.goormthonuniv.hoseo.hochi.domain.user.userRouteHistory.exception.UserRouteHistoryNotFoundException;
import com.goormthonuniv.hoseo.hochi.domain.user.userRouteHistory.repository.UserRouteHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.goormthonuniv.hoseo.hochi.global.util.GlobalCrudUtil.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserRouteHistoryCrudService {

    private final UserRouteHistoryRepository repository;

    public List<UserRouteHistory> findByUserId(Long userId) {
        return findListByOneField(repository::findByUserId, userId,
                () -> new UserRouteHistoryNotFoundException("userId : " + userId));
    }

    public List<UserRouteHistory> findByRouteHistoryId(Long routeId) {
        return findListByOneField(repository::findByRouteHistoryId, routeId,
                () -> new UserRouteHistoryNotFoundException("routeId : " + routeId));
    }

    public UserRouteHistory findById(Long id) {
        return findByField(repository::findById, id,
                () -> new UserRouteHistoryNotFoundException("id : " + id));
    }


    @Transactional
    public void save(UserRouteHistory entity) {
        saveEntity(repository, entity,
                () -> new UserRouteHistoryDuplicateException("중복된 값 저장 DB제약 확인(Unique Or Not Null)"));
    }


    @Transactional
    public void deleteById(Long id){
        deleteByField(repository::findById, id,
                () -> new UserRouteHistoryNotFoundException("id : " + id), repository);
    }

}

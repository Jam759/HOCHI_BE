package com.goormthonuniv.hoseo.hochi.domain.favorite.userFavoritePlace.service;

import com.goormthonuniv.hoseo.hochi.domain.favorite.userFavoritePlace.entity.UserFavoritePlace;
import com.goormthonuniv.hoseo.hochi.domain.favorite.userFavoritePlace.exception.UserFavoriteDuplicateException;
import com.goormthonuniv.hoseo.hochi.domain.favorite.userFavoritePlace.exception.UserFavoriteNotFoundException;
import com.goormthonuniv.hoseo.hochi.domain.favorite.userFavoritePlace.repository.UserFavoritePlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.goormthonuniv.hoseo.hochi.global.util.GlobalCrudUtil.*;

@Service
@RequiredArgsConstructor
public class UserFavoritePlaceCrudService {

    private final UserFavoritePlaceRepository repository;

    public List<UserFavoritePlace> findByUserId(Long userId) {
        return findListByOneField(repository::findByUserId, userId
                ,() -> new UserFavoriteNotFoundException("User Id : " + userId));
    }

    public void save(UserFavoritePlace entity){
        saveEntity(repository, entity,
                () -> new UserFavoriteDuplicateException("중복된 값 저장 DB제약 확인(Unique Or Not Null)"));
    }

    public UserFavoritePlace findById(Long id){
        return findByField(repository::findById, id
                ,() -> new UserFavoriteNotFoundException("id : " + id));
    }

    public void deleteById(Long id){
        deleteByField(repository::findById,
                id, () ->new UserFavoriteNotFoundException("id : " + id), repository);
    }

}

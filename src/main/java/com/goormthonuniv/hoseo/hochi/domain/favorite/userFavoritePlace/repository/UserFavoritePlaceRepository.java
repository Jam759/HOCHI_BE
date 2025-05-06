package com.goormthonuniv.hoseo.hochi.domain.favorite.userFavoritePlace.repository;

import com.goormthonuniv.hoseo.hochi.domain.favorite.userFavoritePlace.entity.UserFavoritePlace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserFavoritePlaceRepository extends JpaRepository<UserFavoritePlace, Long> {
    List<UserFavoritePlace> findByUserId(Long userId);

}

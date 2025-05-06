package com.goormthonuniv.hoseo.hochi.global.security.refreshToken.service;

import com.goormthonuniv.hoseo.hochi.global.security.refreshToken.entity.RefreshToken;
import com.goormthonuniv.hoseo.hochi.global.security.refreshToken.exception.RefreshTokenDuplicateException;
import com.goormthonuniv.hoseo.hochi.global.security.refreshToken.exception.RefreshTokenNotFoundException;
import com.goormthonuniv.hoseo.hochi.global.security.refreshToken.repository.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.goormthonuniv.hoseo.hochi.global.util.GlobalCrudUtil.*;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RefreshTokenCrudService {

    private RefreshTokenRepository repository;

    public RefreshToken findByUserId(Long userId) {
        return findByField(repository::findByUserId, userId,
                () -> new RefreshTokenNotFoundException("usesrId"+userId));
    }


    @Transactional
    public void updateRefreshToken(String refreshToken, Long userId) {
        RefreshToken userRefreshToken = findByField(repository::findByUserId, userId,  () -> new RefreshTokenNotFoundException("usesrId : "+userId));

        userRefreshToken.updateRefreshToken(refreshToken);

        saveEntity(repository, userRefreshToken, () -> new RefreshTokenDuplicateException("중복된 값 저장 DB제약 확인(Unique Or Not Null)"));
    }

    @Transactional
    public void deleteById(Long id){
        deleteByField(repository::findById, id, () -> new RefreshTokenNotFoundException("id : "+id), repository);
    }

}

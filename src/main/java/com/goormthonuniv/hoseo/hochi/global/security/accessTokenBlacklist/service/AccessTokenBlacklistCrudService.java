package com.goormthonuniv.hoseo.hochi.global.security.accessTokenBlacklist.service;

import com.goormthonuniv.hoseo.hochi.global.security.accessTokenBlacklist.entity.AccessTokenBlacklist;
import com.goormthonuniv.hoseo.hochi.global.security.accessTokenBlacklist.exception.AccessTokenBlacklistDuplicateException;
import com.goormthonuniv.hoseo.hochi.global.security.accessTokenBlacklist.exception.AccessTokenBlacklistNotFound;
import com.goormthonuniv.hoseo.hochi.global.security.accessTokenBlacklist.repository.AccessTokenBlacklistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.goormthonuniv.hoseo.hochi.global.util.GlobalCrudUtil.*;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AccessTokenBlacklistCrudService {

    private AccessTokenBlacklistRepository repository;

    public AccessTokenBlacklist findById(String jti) {
        return findByField(repository::findById, jti,
                () -> new AccessTokenBlacklistNotFound("jti : "+ jti));
    }

    @Transactional
    public void save(AccessTokenBlacklist entity){
        saveEntity(repository, entity,
                () -> new AccessTokenBlacklistDuplicateException("중복된 값 저장 DB제약 확인(Unique Or Not Null)"));
    }


    @Transactional(readOnly = true)
    public void deleteById(String jti){
        deleteByField(repository::findById, jti,
                () -> new AccessTokenBlacklistNotFound("jti : "+ jti), repository);
    }

}

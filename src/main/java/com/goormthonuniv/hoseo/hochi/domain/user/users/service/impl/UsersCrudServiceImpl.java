package com.goormthonuniv.hoseo.hochi.domain.user.users.service.impl;

import com.goormthonuniv.hoseo.hochi.domain.user.users.entity.Users;
import com.goormthonuniv.hoseo.hochi.domain.user.users.entity.enums.UserRole;
import com.goormthonuniv.hoseo.hochi.domain.user.users.exception.UserDuplicateKeyException;
import com.goormthonuniv.hoseo.hochi.domain.user.users.exception.UserNotFoundException;
import com.goormthonuniv.hoseo.hochi.domain.user.users.repository.UsersRepository;
import com.goormthonuniv.hoseo.hochi.domain.user.users.service.UsersCrudService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.goormthonuniv.hoseo.hochi.global.util.GlobalCrudUtil.*;


/**
 * 클래스이름 그대로 DB작업을 위한 서비스입니다.
 * 이곳은 DB관련 로직을 수행하면서 예외를 던집니다.
 * CRUD서비스는 항상 ENTITY를 그대로 리턴해야합니다.
 */
@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UsersCrudServiceImpl implements UsersCrudService {


    private final UsersRepository usersRepository;


    @Override
    public Users save(Users user) {
        try {
            return entitySave(usersRepository, user);
        } catch (DataIntegrityViolationException e) {
            log.error("[USER_CRUD] 중복 저장 시도 - nickname: {}", user.getNickname());
            throw new UserDuplicateKeyException(user.getNickname());
        }
    }

    @Override
    public Users findById(Long id) {
        return findByField(usersRepository::findById, id, () -> new UserNotFoundException("UserId : " + id.toString()));
    }

    @Override
    public Users findByNickname(String nickname) {
        return findByField(usersRepository::findByNickname, nickname, () -> new UserNotFoundException("UserNickname : " + nickname));
    }

    @Override
    public void updateRole(Users user, UserRole role) {
        user.updateRole(role);

    }

    @Override
    public void updateNickname(Users user, String nickname) {
        user.updateNickname(nickname);
    }


    @Override
    public void deleteById(Long id) {
        deleteByField(usersRepository::findById, id,
                () -> new UserNotFoundException("UserId : " + id.toString()),
                usersRepository);
    }

}

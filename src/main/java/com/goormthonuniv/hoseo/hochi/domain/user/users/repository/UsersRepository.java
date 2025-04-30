package com.goormthonuniv.hoseo.hochi.domain.user.users.repository;

import com.goormthonuniv.hoseo.hochi.domain.user.users.entity.Users;
import com.goormthonuniv.hoseo.hochi.domain.user.users.entity.enums.OauthType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


/**
 * DB와 직접적으로 작업하는 놈입니다.
 */
public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByNickname(String nickname);
    Optional<Users> findByOauthAndOauthId(OauthType oauth, String oauthId);
}

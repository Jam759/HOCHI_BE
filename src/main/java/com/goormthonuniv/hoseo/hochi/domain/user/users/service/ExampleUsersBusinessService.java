package com.goormthonuniv.hoseo.hochi.domain.user.users.service;


import com.goormthonuniv.hoseo.hochi.domain.user.users.dto.request.ExampleUserNicknameUpdateRequest;
import com.goormthonuniv.hoseo.hochi.domain.user.users.dto.response.ExampleUserResponse;
import org.springframework.stereotype.Service;

/**
 * 단일 테이블에서 하나의 요청에 대한 처리가 가능한경우 비즈니스서비스를 만듭니다.
 * 비즈니스서비스는 말 그대로 비즈니스 로직만 수행합니다.
 * 이 서비스는 CRUD서비스를 주입받으며, 컨트롤러의 요청에 응답합니다.
 * 이때 반환값을 절대로 DTO를 하셔야합니다.
 */
public interface ExampleUsersBusinessService {

    ExampleUserResponse getUserInfo(Long userId);
    ExampleUserResponse updateUserNickname(ExampleUserNicknameUpdateRequest request, Long userId);

}

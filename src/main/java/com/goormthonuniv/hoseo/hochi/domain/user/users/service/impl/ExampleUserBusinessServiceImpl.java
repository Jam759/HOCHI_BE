package com.goormthonuniv.hoseo.hochi.domain.user.users.service.impl;

import com.goormthonuniv.hoseo.hochi.domain.user.users.dto.request.ExampleUserNicknameUpdateRequest;
import com.goormthonuniv.hoseo.hochi.domain.user.users.dto.response.ExampleUserResponse;
import com.goormthonuniv.hoseo.hochi.domain.user.users.entity.Users;
import com.goormthonuniv.hoseo.hochi.domain.user.users.service.ExampleUsersBusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.goormthonuniv.hoseo.hochi.domain.user.users.dto.UserDtoConverter.UsersToExampleUserResponse;


/**
 * ExampleUsersBusinessService의 구현체입니다.
 * 보고오시면 BusinessService역할 나와있습니다.
 */
@Service
@RequiredArgsConstructor
public class ExampleUserBusinessServiceImpl implements ExampleUsersBusinessService {

    private final UsersCrudServiceImpl usersCrudService;

    @Override
    public ExampleUserResponse getUserInfo(Long userId) {
        Users user = usersCrudService.findById(userId);

        /**
         * 저 같은경우 엔티티안에 변환로직은 안넣고 클래스 형태를 바꿔주는 로직을 가진 클래스를 만들어서 사용합니다.
         * dto패키지안에 UserDtoConverter보시면 있어요.
         * ps. UsersToExampleUserResponse더블클릭 후 Ctrl + B 같이 누르면 선언문으로 이동합니다.
         */
        return UsersToExampleUserResponse(user);
    }

    @Override
    public ExampleUserResponse updateUserNickname(ExampleUserNicknameUpdateRequest request, Long userId) {
        Users user = usersCrudService.findById(userId);
        usersCrudService.updateNickname(user, request.getNickname());

        return UsersToExampleUserResponse(user);
    }
}

package com.goormthonuniv.hoseo.hochi.domain.user.users.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 이름 그대로 유저의 닉네임변경 요청 예시 DTO 입니다.
 */

@Getter
@AllArgsConstructor //모든 변수를 가진 생성자를 만들어줍니다.
public class ExampleUserNicknameUpdateRequest {

    private String nickname;

}

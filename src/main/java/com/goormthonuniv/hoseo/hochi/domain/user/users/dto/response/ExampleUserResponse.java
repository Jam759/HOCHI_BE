package com.goormthonuniv.hoseo.hochi.domain.user.users.dto.response;

import com.goormthonuniv.hoseo.hochi.domain.user.users.entity.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ExampleUserResponse {
    private String email;
    private String nickname;
    private UserRole role;    // 예: USER
}

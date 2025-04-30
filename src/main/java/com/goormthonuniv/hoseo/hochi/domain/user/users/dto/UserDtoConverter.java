package com.goormthonuniv.hoseo.hochi.domain.user.users.dto;

import com.goormthonuniv.hoseo.hochi.domain.user.users.dto.response.ExampleUserResponse;
import com.goormthonuniv.hoseo.hochi.domain.user.users.entity.Users;

public class UserDtoConverter {

    public static ExampleUserResponse UsersToExampleUserResponse(Users user){
        return ExampleUserResponse.builder()
                .email(user.getEmail())
                .nickname(user.getNickname())
                .role(user.getRole())
                .build();
    }

}

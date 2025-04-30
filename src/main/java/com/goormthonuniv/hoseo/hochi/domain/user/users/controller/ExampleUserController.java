package com.goormthonuniv.hoseo.hochi.domain.user.users.controller;

import com.goormthonuniv.hoseo.hochi.domain.user.users.dto.request.ExampleUserNicknameUpdateRequest;
import com.goormthonuniv.hoseo.hochi.domain.user.users.dto.response.ExampleUserResponse;
import com.goormthonuniv.hoseo.hochi.domain.user.users.entity.Users;
import com.goormthonuniv.hoseo.hochi.domain.user.users.service.impl.ExampleUserBusinessServiceImpl;
import com.goormthonuniv.hoseo.hochi.global.security.UserDetailsImpl.entity.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class ExampleUserController {

    private final ExampleUserBusinessServiceImpl userBusinessService;

    @GetMapping("/tes")
    public ExampleUserResponse h(){
        return userBusinessService.getUserInfo(1L);
    }

    //쉬운 예시
    @GetMapping()
    public ExampleUserResponse getUserInfo(@AuthenticationPrincipal UserDetailsImpl principal) {
        Users user = principal.getUser();
        return userBusinessService.getUserInfo(user.getId());
    }

    //응용 예시
    @PostMapping()
    public ExampleUserResponse updateUserNickname(@RequestBody ExampleUserNicknameUpdateRequest request,
                                                  @AuthenticationPrincipal UserDetailsImpl principal) {
        Users user = principal.getUser();
        return userBusinessService.updateUserNickname(request, user.getId());
    }

}

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

    // 예시 현재 @AuthenticationPrincipal UserDetailsImpl principal이부분은 동작 안할테니
    // 유저의 관한 정보가 필요할 경우 유저에 관한 파람을 Long userId 이런식으로 선언한 다음 서비스에 필요한 인자 넘겨주세요.
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

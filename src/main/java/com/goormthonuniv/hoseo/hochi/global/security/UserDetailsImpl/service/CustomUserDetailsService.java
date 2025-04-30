package com.goormthonuniv.hoseo.hochi.global.security.UserDetailsImpl.service;


import com.goormthonuniv.hoseo.hochi.domain.user.users.entity.Users;
import com.goormthonuniv.hoseo.hochi.domain.user.users.service.impl.UsersCrudServiceImpl;
import com.goormthonuniv.hoseo.hochi.global.security.UserDetailsImpl.entity.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private UsersCrudServiceImpl usersCrudService;

    public UserDetails loadUserByUserId(Long userId) throws UsernameNotFoundException{
        Users user = usersCrudService.findById(userId);
        return new UserDetailsImpl(user);
    }

    @Override
    public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {
        Users user = usersCrudService.findByNickname(nickname);
        return new UserDetailsImpl(user);
    }

}

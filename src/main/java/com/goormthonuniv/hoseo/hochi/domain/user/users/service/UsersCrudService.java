package com.goormthonuniv.hoseo.hochi.domain.user.users.service;

import com.goormthonuniv.hoseo.hochi.domain.user.users.entity.Users;
import com.goormthonuniv.hoseo.hochi.domain.user.users.entity.enums.UserRole;

public interface UsersCrudService {
    // Create
    Users save(Users user);

    // Read
    Users findById(Long id);

    Users findByNickname(String nickname);

    // Update
    void updateRole(Users user, UserRole role);
    void updateNickname(Users user, String nickname);


    // Delete
    void deleteById(Long id);
}

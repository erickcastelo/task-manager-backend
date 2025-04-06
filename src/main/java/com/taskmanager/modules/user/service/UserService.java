package com.taskmanager.modules.user.service;

import com.taskmanager.modules.user.dto.UserCreateRequest;
import com.taskmanager.modules.user.model.User;

public interface UserService {
    User createUser(UserCreateRequest userCreateRequest);
    User getReferenceUserById(Long id);
    User getUserByEmail(String email);
}

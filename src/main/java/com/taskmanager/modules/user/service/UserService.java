package com.taskmanager.modules.user.service;

import com.taskmanager.modules.user.dto.UserCreateRequest;
import com.taskmanager.modules.user.model.User;
import java.util.UUID;

public interface UserService {
    User createUser(UserCreateRequest userCreateRequest);
    User getReferenceUserById(UUID id);
    User getUserByEmail(String email);
}

package com.taskmanager.modules.auth.service;

import com.taskmanager.modules.user.model.User;

public interface AuthService {
    String login(String email, String password);
    User me (String token);
}

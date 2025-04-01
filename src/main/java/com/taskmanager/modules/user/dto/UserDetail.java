package com.taskmanager.modules.user.dto;

import com.taskmanager.modules.user.model.User;

public record UserDetail(Long id, String name, String email) {

    public UserDetail(User user) {
        this(user.getId(), user.getName(), user.getEmail());
    }
}

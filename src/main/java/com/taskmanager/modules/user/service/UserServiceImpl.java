package com.taskmanager.modules.user.service;

import com.taskmanager.common.PasswordEncoderConfig;
import com.taskmanager.modules.user.dto.UserCreateRequest;
import com.taskmanager.modules.user.model.User;
import com.taskmanager.modules.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoderConfig passwordEncoderConfig;

    @Override
    public User createUser(UserCreateRequest userCreateRequest) {
        User user = new User(userCreateRequest, this.passwordEncoderConfig);
        this.userRepository.save(user);

        return user;
    }

    @Override
    public User getReferenceUserById(Long id) {
        return this.userRepository.getReferenceById(id);
    }
}

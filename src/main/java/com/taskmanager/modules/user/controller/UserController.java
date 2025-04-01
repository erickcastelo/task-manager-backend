package com.taskmanager.modules.user.controller;

import com.taskmanager.modules.user.dto.UserCreateRequest;
import com.taskmanager.modules.user.dto.UserDetail;
import com.taskmanager.modules.user.model.User;
import com.taskmanager.modules.user.service.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @Transactional
    public ResponseEntity<UserDetail> createUser(@RequestBody @Valid UserCreateRequest userCreateRequest, UriComponentsBuilder uriBuilder) {
        User user = this.userService.createUser(userCreateRequest);

        URI uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).body(new UserDetail(user));
    }
}

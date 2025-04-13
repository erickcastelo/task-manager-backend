package com.taskmanager.modules.auth.controller;

import com.taskmanager.modules.auth.dto.LoginRequest;
import com.taskmanager.modules.auth.service.AuthService;
import com.taskmanager.modules.user.dto.UserDetail;
import com.taskmanager.modules.user.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginRequest loginRequest) {
        String token = this.authService.login(loginRequest.email(), loginRequest.password());
        return ResponseEntity.ok(token);
    }

    @GetMapping("/me/{token}")
    public ResponseEntity<UserDetail> me(@PathVariable String token) {
        User user = this.authService.me(token);
        return ResponseEntity.ok(new UserDetail(user));
    }
}

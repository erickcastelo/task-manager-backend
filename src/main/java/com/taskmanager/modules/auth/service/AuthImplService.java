package com.taskmanager.modules.auth.service;

import com.taskmanager.common.config.JwtConfig;
import com.taskmanager.modules.user.model.User;
import com.taskmanager.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class AuthImplService implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtConfig jwtConfig;

    @Autowired
    private UserService userService;

    @Override
    public String login(String email, String password) {
        try {
            Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(email, password));

            if (authentication.isAuthenticated()) {
                return this.jwtConfig.generateToken(email);
            }
            throw new BadCredentialsException("Failed on authentication.");
        } catch (AuthenticationException ex) {
            throw new BadCredentialsException("Email or password invalid.", ex);
        }
    }

    @Override
    public User me(String token) {
        String username = this.jwtConfig.extractUsername(token);
        return this.userService.getUserByEmail(username);
    }
}

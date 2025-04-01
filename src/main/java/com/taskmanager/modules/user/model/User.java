package com.taskmanager.modules.user.model;

import com.taskmanager.common.PasswordEncoderConfig;
import com.taskmanager.modules.user.dto.UserCreateRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "users")
@Entity(name = "User")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String password;

    public User(UserCreateRequest userCreateRequest, PasswordEncoderConfig passwordEncoderConfig) {
        this.name = userCreateRequest.name();
        this.email = userCreateRequest.email();
        this.password = passwordEncoderConfig.encodePassword(userCreateRequest.password());
    }
}

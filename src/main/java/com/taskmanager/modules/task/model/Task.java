package com.taskmanager.modules.task.model;

import com.taskmanager.modules.user.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "tasks")
@Entity(name = "Task")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    private LocalDateTime dueAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

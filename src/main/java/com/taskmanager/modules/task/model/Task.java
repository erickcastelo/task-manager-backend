package com.taskmanager.modules.task.model;

import com.taskmanager.modules.task.dto.TaskCreateRequest;
import com.taskmanager.modules.task.dto.TaskUpdateRequest;
import com.taskmanager.modules.user.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

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

    public Task(TaskCreateRequest taskCreateRequest, User user) {
        this.title = taskCreateRequest.title();
        this.description = taskCreateRequest.description();
        this.status = taskCreateRequest.status();
        this.dueAt = taskCreateRequest.dueAt();
        this.user = user;
    }

    public void updateTask(TaskUpdateRequest taskUpdateRequest) {
        this.title = Objects.requireNonNullElse(taskUpdateRequest.title(), this.title);
        this.description = Objects.requireNonNullElse(taskUpdateRequest.description(), this.description);
        this.status = Objects.requireNonNullElse(taskUpdateRequest.status(), this.status);
        this.dueAt = Objects.requireNonNullElse(taskUpdateRequest.dueAt(), this.dueAt);
    }
}

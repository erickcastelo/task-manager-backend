package com.taskmanager.modules.task.dto;

import com.taskmanager.modules.task.model.Task;
import com.taskmanager.modules.task.model.TaskStatus;
import com.taskmanager.modules.user.model.User;

import java.time.LocalDateTime;
import java.util.UUID;

public record TaskDetail(UUID id, String title, String description, TaskStatus status, LocalDateTime dueAt) {

    public TaskDetail(Task task) {
        this(task.getId(), task.getTitle(), task.getDescription(), task.getStatus(), task.getDueAt());
    }
}

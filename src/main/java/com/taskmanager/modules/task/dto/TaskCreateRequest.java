package com.taskmanager.modules.task.dto;

import com.taskmanager.modules.task.model.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record TaskCreateRequest(

        @NotBlank
        String title,

        @NotBlank
        String description,

        @NotNull
        TaskStatus status,

        @NotNull
        LocalDateTime dueAt
) {
}

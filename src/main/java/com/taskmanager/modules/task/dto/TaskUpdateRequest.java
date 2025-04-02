package com.taskmanager.modules.task.dto;

import com.taskmanager.modules.task.model.TaskStatus;
import java.time.LocalDateTime;

public record TaskUpdateRequest(
    String title,
    String description,
    TaskStatus status,
    LocalDateTime dueAt
) {

}

package com.taskmanager.modules.task.service;

import com.taskmanager.modules.task.dto.TaskCreateRequest;
import com.taskmanager.modules.task.dto.TaskUpdateRequest;
import com.taskmanager.modules.task.model.Task;
import com.taskmanager.modules.task.model.TaskStatus;
import com.taskmanager.modules.user.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface TaskService {
    Page<Task> listTasks(Pageable pageable, TaskStatus status);
    Task createTask(TaskCreateRequest taskCreateRequest);
    Task getReferenceTaskById(UUID id);
    Task updateTask(UUID id, TaskUpdateRequest taskUpdateRequest);
    void deleteTask(UUID id);
}

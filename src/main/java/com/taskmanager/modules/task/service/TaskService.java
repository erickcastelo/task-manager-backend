package com.taskmanager.modules.task.service;

import com.taskmanager.modules.task.dto.TaskCreateRequest;
import com.taskmanager.modules.task.model.Task;

public interface TaskService {
    Task createTask(TaskCreateRequest taskCreateRequest);
}

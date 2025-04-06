package com.taskmanager.modules.task.service;

import com.taskmanager.modules.task.dto.TaskCreateRequest;
import com.taskmanager.modules.task.dto.TaskUpdateRequest;
import com.taskmanager.modules.task.model.Task;
import com.taskmanager.modules.task.model.TaskStatus;
import com.taskmanager.modules.task.repository.TaskRepository;
import com.taskmanager.modules.user.model.User;
import com.taskmanager.modules.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private UserService userService;

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Page<Task> listTasks(Pageable pageable, TaskStatus status) {
        if (status != null) {
            return taskRepository.findByStatus(status, pageable);
        }
        return this.taskRepository.findAll(pageable);
    }

    @Override
    public Task createTask(TaskCreateRequest taskCreateRequest) {
        User user = this.userService.getReferenceUserById(1L); //TODO: change to logged in user

        Task task = new Task(taskCreateRequest, user);
        this.taskRepository.save(task);

        return task;
    }

    @Override
    public Task getReferenceTaskById(Long id) {
        return this.taskRepository.getReferenceById(id);
    }

    @Override
    public Task updateTask(Long id, TaskUpdateRequest taskUpdateRequest) {
        Task task = this.taskRepository.getReferenceById(id);
        task.updateTask(taskUpdateRequest);

        return task;
    }

    @Override
    public void deleteTask(Long id) {
        this.taskRepository.deleteById(id);
    }
}

package com.taskmanager.modules.task.controller;

import com.taskmanager.modules.task.dto.TaskCreateRequest;
import com.taskmanager.modules.task.dto.TaskDetail;
import com.taskmanager.modules.task.model.Task;
import com.taskmanager.modules.task.service.TaskService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    @Transactional
    public ResponseEntity<TaskDetail> createTask(@RequestBody TaskCreateRequest taskCreateRequest, UriComponentsBuilder uriBuilder) {
        Task task = this.taskService.createTask(taskCreateRequest);

        URI uri = uriBuilder.path("/users/{id}").buildAndExpand(task.getId()).toUri();

        return ResponseEntity.created(uri).body(new TaskDetail(task));
    }
}

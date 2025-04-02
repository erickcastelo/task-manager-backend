package com.taskmanager.modules.task.controller;

import com.taskmanager.modules.task.dto.TaskCreateRequest;
import com.taskmanager.modules.task.dto.TaskDetail;
import com.taskmanager.modules.task.dto.TaskUpdateRequest;
import com.taskmanager.modules.task.model.Task;
import com.taskmanager.modules.task.model.TaskStatus;
import com.taskmanager.modules.task.service.TaskService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<Page<TaskDetail>> listTasks(@RequestParam(required = false) TaskStatus status, Pageable pageable) {
        System.out.println(status);
        Page<TaskDetail> taskDetails = this.taskService.listTasks(pageable, status).map(TaskDetail::new);
        return ResponseEntity.ok(taskDetails);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<TaskDetail> createTask(@RequestBody @Valid TaskCreateRequest taskCreateRequest, UriComponentsBuilder uriBuilder) {
        Task task = this.taskService.createTask(taskCreateRequest);

        URI uri = uriBuilder.path("/users/{id}").buildAndExpand(task.getId()).toUri();

        return ResponseEntity.created(uri).body(new TaskDetail(task));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TaskDetail> updateTask(@RequestBody @Valid TaskUpdateRequest taskUpdateRequest, @PathVariable Long id) {
        Task task = this.taskService.updateTask(id, taskUpdateRequest);

        return ResponseEntity.ok(new TaskDetail(task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        this.taskService.deleteTask(id);

        return ResponseEntity.noContent().build();
    }
}

package com.taskmanager.modules.task.repository;

import com.taskmanager.modules.task.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}

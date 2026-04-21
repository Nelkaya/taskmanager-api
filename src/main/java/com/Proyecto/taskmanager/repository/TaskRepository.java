package com.Proyecto.taskmanager.repository;

import com.Proyecto.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}

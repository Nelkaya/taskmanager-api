package com.Proyecto.taskmanager.controller;

import com.Proyecto.taskmanager.dto.TaskDTO;
import com.Proyecto.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@Tag(name = "Tareas", description = "API para gestión de tareas")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service){
        this.service = service;
    }

    @Operation(summary = "Listar todas las tareas")
    @GetMapping
    public List<TaskDTO> listar() {
        return service.getAllTasks();
    }

    @Operation(summary = "Crear una nueva tarea")
    @PostMapping
    public TaskDTO crear(@Valid @RequestBody TaskDTO dto){
        return service.createTask(dto);
    }

    @GetMapping("/{id}")
    public TaskDTO obtenerPorId(@PathVariable Long id){
        return service.getTaskById(id);
    }

    @PutMapping("/{id}")
    public TaskDTO actualizar(@PathVariable Long id, @Valid @RequestBody TaskDTO dto){
        return service.updateTask(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        service.deleteTask(id);
    }
}

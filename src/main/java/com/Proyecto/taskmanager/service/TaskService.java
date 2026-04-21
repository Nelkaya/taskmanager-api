package com.Proyecto.taskmanager.service;

import com.Proyecto.taskmanager.dto.TaskDTO;
import com.Proyecto.taskmanager.exception.ResourceNotFoundException;
import com.Proyecto.taskmanager.model.Task;
import com.Proyecto.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public List<TaskDTO> getAllTasks() {
        return repository.findAll().stream().map(this::toDTO).toList();
    }

    public TaskDTO createTask(TaskDTO dto){
        Task task = toEntity(dto);
        return toDTO(repository.save(task));
    }

    public TaskDTO getTaskById(Long id){
        Task task = repository.findById(id)
                //.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarea no encontrada")); //metodo 1
                .orElseThrow(() -> new ResourceNotFoundException("Tarea no encontrada")); //metodo 2

        return toDTO(task);
    }

    public TaskDTO updateTask(Long id, TaskDTO dto){
        Task existente = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarea no encontrada"));

        existente.setTitulo(dto.getTitulo());
        existente.setDescripcion(dto.getDescripcion());
        existente.setCompletada(dto.isCompletada());

        return toDTO(repository.save(existente));
    }

    public void deleteTask(Long id){
        Task task = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tarea no encontrada"));

        repository.delete(task);
    }

    //Entity -> DTO
    private TaskDTO toDTO(Task task){
        return new TaskDTO(
                task.getId(),
                task.getTitulo(),
                task.getDescripcion(),
                task.isCompletada()
        );
    }
    //DTO -> Entity
    private Task toEntity(TaskDTO dto){
        return new Task(
                dto.getId(),
                dto.getTitulo(),
                dto.getDescripcion(),
                dto.isCompletada()
        );
    }
}

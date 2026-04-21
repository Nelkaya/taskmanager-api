package com.Proyecto.taskmanager.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {

    private Long id;

    @NotBlank(message = "El titulo es un campo obligatorio")
    private String titulo;

    @Size(min = 5, max = 100, message = "La descripcion debe tener entre 5 y 100 caracteres")
    private String descripcion;

    @NotNull(message = "El estado es obligatorio")
    private boolean completada;
}

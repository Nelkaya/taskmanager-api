# 📝 Task Manager API

API REST desarrollada con Spring Boot para la gestión de tareas (CRUD completo), aplicando buenas prácticas de arquitectura en capas, validaciones, manejo de errores y documentación con Swagger.

## 🚀 Tecnologías utilizadas

* Java 17
* Spring Boot
* Spring Data JPA
* MySQL
* Lombok
* Swagger (Springdoc OpenAPI)

## 🧱 Arquitectura

El proyecto sigue una arquitectura en capas:

* **Controller** → Manejo de peticiones HTTP
* **Service** → Lógica de negocio
* **Repository** → Acceso a datos
* **DTO** → Transferencia de datos
* **Exception** → Manejo global de errores

## 📌 Funcionalidades

* Crear tarea
* Listar todas las tareas
* Obtener tarea por ID
* Actualizar tarea
* Eliminar tarea
* Validación de datos de entrada
* Manejo de errores personalizado

## 🔗 Endpoints principales

| Método | Endpoint        | Descripción          |
| ------ | --------------- | -------------------- |
| GET    | /api/tasks      | Listar tareas        |
| GET    | /api/tasks/{id} | Obtener tarea por ID |
| POST   | /api/tasks      | Crear tarea          |
| PUT    | /api/tasks/{id} | Actualizar tarea     |
| DELETE | /api/tasks/{id} | Eliminar tarea       |

## 📘 Documentación Swagger

Una vez ejecutado el proyecto, puedes acceder a la documentación en:

http://localhost:8081/swagger-ui/index.html

## ⚙️ Configuración del proyecto

### Paso 1. Clonar repositorio

git clone https://github.com/Nelkaya/taskmanager.git

### Paso 2. Crear base de datos

CREATE DATABASE taskdb;

### Paso 3. Configurar credenciales

Editar archivo:

src/main/resources/application.properties

spring.datasource.url=jdbc:mysql://localhost:3306/taskdb
spring.datasource.username=TU_USUARIO
spring.datasource.password=TU_PASSWORD

### Paso 4. Ejecutar proyecto

Desde el IDE o con:

mvn spring-boot:run

## 🧪 Ejemplo de request (POST)

{
"titulo": "Estudiar backend",
"descripcion": "Practicar Spring Boot",
"completada": false
}

## Autor

Desarrollado por Andres Felipe Perez Victoria.

Estudiante de Ingeniería de Sistemas.


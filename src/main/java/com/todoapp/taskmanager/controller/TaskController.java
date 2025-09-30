package com.todoapp.taskmanager.controller;

import com.todoapp.taskmanager.model.Task;
import com.todoapp.taskmanager.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController //contiene las anotaciones @Controller(peticiones HTTP) y @ResponseBody(Respuesta en JSON)
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;


    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAll(){
        List<Task> tasks = service.findAll();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getById(@PathVariable Long id){
        Task task = service.findById(id);
        return ResponseEntity.ok(task);
    }

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody Task task) {  // En resumen:La URI en este endpoint sirve para devolver al cliente la dirección única del recurso recién creado. Así, después de hacer un POST a /tasks, el cliente recibe un 201 Created con un Location: /tasks/{id} que le dice dónde puede consultar ese recurso.
        Task created = service.create(task);
        URI location = URI.create("/tasks/" + created.getId()); // Una URI (Uniform Resource Identifier) es la dirección que identifica de forma única a un recurso en la API.
        return ResponseEntity.created(location).body(created); //genera un HTTP 201 Created con un encabezado Location.
    }

    @PutMapping


    
}

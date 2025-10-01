package com.todoapp.taskmanager.service;

import com.todoapp.taskmanager.model.Task;

import java.util.List;

public interface TaskService {

    //vamoa a creal los metodos de un crud elemental

    List<Task> createAll(List<Task> tasks); // crear varias tareas (bulk
    Task create(Task task);          // crear una tarea
    List<Task> findAll();            // listar todas las tareas
    Task findById(Long id);          // buscar por id
    Task update(Long id, Task task); // actualizar tarea
    void delete(Long id);            // eliminar tarea

}

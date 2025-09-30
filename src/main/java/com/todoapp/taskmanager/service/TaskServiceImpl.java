package com.todoapp.taskmanager.service;

import com.todoapp.taskmanager.exception.ResourceNotFoundException;
import com.todoapp.taskmanager.model.Task;
import com.todoapp.taskmanager.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TaskServiceImpl implements TaskService{

    private final TaskRepository repo;

    // Inyección por constructor (mejor práctica)
    public TaskServiceImpl(TaskRepository repo) {
        this.repo = repo;
    }


    @Override
    public Task create(Task task) {
        if(task == null) throw new IllegalArgumentException("La tarea no debe ser nula");
        if(task.getTitle() == null || task.getTitle().isBlank()){
            throw new IllegalArgumentException("Titulo es requerido");
        }
        return repo.save(task);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Task> findAll() {
        return repo.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Task findById(Long id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tarea no encontrada con id " + id)); //Acuerdate que JPA EN EL METODO findById devuelve Options<task> por eso el orElse
    }

    @Override
    public Task update(Long id, Task task) {

        Task existing = findById(id); // lanza excepción si no existe
        // Actualizamos solo los campos que nos interesan:
        if (task.getTitle() != null && !task.getTitle().isBlank()) {
            existing.setTitle(task.getTitle());
        }
        // para boolean es habitual sobrescribir el valor
        existing.setCompleted(task.isCompleted());
        // notamos que no cambiamos createdAt ni id aquí
        return repo.save(existing);
    }

    @Override
    public void delete(Long id) {
        if(!repo.existsById(id)){
            throw new ResourceNotFoundException("Tarea no encoantrada con id " + id);
        }
        repo.deleteById(id);
    }
}

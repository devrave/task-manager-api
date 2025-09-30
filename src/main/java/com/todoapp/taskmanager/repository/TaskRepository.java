package com.todoapp.taskmanager.repository;

import com.todoapp.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository  // opcional: Spring Data lo detecta aunque no lo pongas
public interface TaskRepository extends JpaRepository<Task, Long> {



}

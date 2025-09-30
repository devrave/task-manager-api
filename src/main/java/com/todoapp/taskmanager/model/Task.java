package com.todoapp.taskmanager.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity //para que jpa pueda tener acceso a la informcción
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Generar id automaticamente en la DB H2
    private Long id;

    private String title;
    private boolean completed;
    private LocalDateTime createdAt;


    // Constructor con la variable de created: para que se crre por defecto con fecha actualizada.
    public Task(){
        this.createdAt = LocalDateTime.now();
        this.completed = false;
    }

    //Getter y setter
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    //Ahora vamos a crear un metodo toString para convertir un objeto como texto

    @Override
    public String toString() {
        return "Task{id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                ", createdAt=" + createdAt +
                '}';
    }
}

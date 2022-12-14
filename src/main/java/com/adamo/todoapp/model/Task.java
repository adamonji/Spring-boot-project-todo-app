package com.adamo.todoapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tasks")
public class Task {
    public Task() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "description")
    @NotBlank(message = "Task's description must not be empty")
    private String description;
    private boolean done;

    public int getId()
    {
        return id;
    }

    void setId(int id)
    {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }



    public boolean getDone() {
        return done;
    }

    void setDone(boolean done) {
        this.done = done;
    }
}

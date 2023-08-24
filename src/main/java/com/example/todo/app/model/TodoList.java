package com.example.todo.app.model;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class TodoList {
    @Id
    @SequenceGenerator(name = "todo_list_seq", sequenceName = "todosgenerator", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String taskName;
    private String priority;
    private Boolean isDone;

    public TodoList() {
    }

    public TodoList(String taskName, String priority, Boolean isDone) {
        this.id = UUID.randomUUID();
        this.taskName = taskName;
        this.priority = priority;
        this.isDone = isDone;
    }

    public boolean isValidPriority(String priority) {
        if (priority.equalsIgnoreCase(Constants.MEDIUM_PRIORITY) 
            || priority.equalsIgnoreCase(Constants.HIGH_PRIORITY)
                || priority.equalsIgnoreCase(Constants.LOW_PRIORITY)) 
            return true;
        
        return false;
    }

}

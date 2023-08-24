package com.example.todo.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todo.app.model.TodoList;

public interface TodoDao extends JpaRepository<TodoList,String>{
    
}

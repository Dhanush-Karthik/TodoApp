package com.example.todo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todo.model.TodoList;

public interface TodoDao extends JpaRepository<TodoList,String>{
    
}

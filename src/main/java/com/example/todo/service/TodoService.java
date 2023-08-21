package com.example.todo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.dao.TodoDao;
import com.example.todo.model.TodoList;

@Service
public class TodoService {
    
    @Autowired
    private TodoDao todoDao;

    public TodoService(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    public List<TodoList> getTodoList(){
        return todoDao.findAll();
    } 
    
    public List<TodoList> saveTodoList(TodoList todoList){
        todoDao.save(todoList);
        return Arrays.asList(todoList);
    }
}

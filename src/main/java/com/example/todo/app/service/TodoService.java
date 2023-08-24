package com.example.todo.app.service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todo.app.dao.TodoDao;
import com.example.todo.app.model.TodoList;

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

    // FIXME
    public List<TodoList> updateTodo(TodoList todoList) {
        Optional<TodoList> todo = todoDao.findById(todoList.getId().toString());
        if(!todo.isPresent()){
            return Collections.emptyList();
        }
        TodoList res = todo.get();
        TodoList modifiedTodo = new TodoList(res.getTaskName(), res.getPriority(), res.getIsDone());
        modifiedTodo.setId(res.getId());
        todoDao.save(modifiedTodo);

        return Arrays.asList(modifiedTodo);
    }

    // FIXME
    public List<TodoList> deleteTodo(UUID id){
        todoDao.deleteById(id.toString());
        return Collections.emptyList();
    }
}

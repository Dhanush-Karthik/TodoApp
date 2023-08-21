package com.example.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo.model.TodoList;
import com.example.todo.response.Response;
import com.example.todo.service.TodoService;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping()
    public ResponseEntity<List<TodoList>> getTodoList(){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(todoService.getTodoList());
    }

    @PostMapping()
    public ResponseEntity<Response> saveTodoList(@RequestBody TodoList todoList){
        
        if(isBlank(todoList.getTaskName()))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("task cannot be empty", "failure")); 

        if(isBlank(todoList.getPriority()))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("priority cannot be empty", "failure"));    
        
        if(todoList.getIsDone()==null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("isDone cannot be empty", "failure"));    
        
        if(!todoList.isValidPriority(todoList.getPriority()))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Response("invalid priority", "failure"));
        
        return ResponseEntity.status(HttpStatus.CREATED).body(new Response("user created", "sucess", todoService.saveTodoList(todoList)));
    }

    
    private boolean isBlank(String data){
        return data.equals("") || data==null;
    }
}

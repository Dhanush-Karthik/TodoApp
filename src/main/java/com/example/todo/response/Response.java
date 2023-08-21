package com.example.todo.response;

import java.util.Collections;
import java.util.List;

import com.example.todo.model.TodoList;

import lombok.Data;

@Data
public class Response {
    private String message;
    private String status;
    private List<TodoList> data;

    public Response(String message, String status) {
        this.message = message;
        this.status = status;
        this.data = Collections.emptyList();
    }

    public Response(String message, String status, List<TodoList> list) {
        this.message = message;
        this.status = status;
        this.data = list;
    }

}

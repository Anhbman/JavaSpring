package com.example.demo.service;

import com.example.demo.model.Todo;

import java.util.List;

public interface ITodoService {

    public Todo addTodo(Todo todo);

    public Todo updateTodo(Integer id, String title);

    public boolean deleteTodo(Integer id);

    public List<Todo> getAllTodo();

    public Todo getOneTodo(Integer id);
}

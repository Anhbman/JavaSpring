package com.example.demo.service;

import com.example.demo.model.Todo;
import com.example.demo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService implements ITodoService{

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public Todo addTodo(Todo todo) {
        if (todo != null)
            return todoRepository.save(todo);
        return null;
    }

    @Override
    public Todo updateTodo(Integer id, String title) {
        Optional<Todo> todo1 = todoRepository.findById(id);
        if (todo1.isPresent()) {
            todo1.get().setTitle(title);
            return todoRepository.save(todo1.get());
        }
        return null;
    }

    @Override
    public boolean deleteTodo(Integer id) {
        Todo todo = todoRepository.findById(id).get();
        if (todo != null) {
            todoRepository.delete(todo);
            return true;
        }
        return false;
    }

    @Override
    public List<Todo> getAllTodo() {
        return todoRepository.findAll();
    }

    @Override
    public Todo getOneTodo(Integer id) {
        Todo todo = todoRepository.findById(id).get();
        if (todo != null)
            return todo;
        return null;
    }
}

package com.example.demo.controller;

import com.example.demo.model.Todo;
import com.example.demo.repository.TodoRepository;
import com.example.demo.service.ITodoService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.TodoService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/api")
public class TodoController {

    @Autowired
    private ITodoService iTodoService;

    @GetMapping(path = "/todos")
    public @ResponseBody List<Todo> getAllTodos() {
        return iTodoService.getAllTodo();
    }

    @PostMapping(path = "/create")
    public @ResponseBody String addNewTodo (@RequestParam String title) {
        Todo todo = new Todo(title);
        iTodoService.addTodo(todo);
        return "Saved";
    }

    @GetMapping(path = "/todos/{id}")
    public Todo getOneTodo(@PathVariable("id") Integer id) {
        return iTodoService.getOneTodo(id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public @ResponseBody String deleteTodo(@PathVariable("id") Integer id) {
        if (iTodoService.deleteTodo(id))
            return "Delete success";
        return "Delete error";
    }

    @PutMapping(value = "/todos/edit/{id}")
    public @ResponseBody String updateTodo(@PathVariable("id") Integer id, @RequestParam String title) {
        System.out.println(id + "-" + title);
        if (iTodoService.updateTodo(id, title) != null)
            return "Update success";
        return "Update error";
    }
}

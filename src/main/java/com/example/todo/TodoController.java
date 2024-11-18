package com.example.todo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private final List<TodoItem> todoList = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong();

    @GetMapping
    public List<TodoItem> getTodos() {
        return todoList;
    }

    @PostMapping
    public TodoItem addTodo(@RequestParam String task) {
        TodoItem newItem = new TodoItem(counter.incrementAndGet(), task);
        todoList.add(newItem);
        return newItem;
    }

    @PutMapping("/{id}")
    public TodoItem completeTodo(@PathVariable Long id) {
        for (TodoItem item : todoList) {
            if (item.getId().equals(id)) {
                item.setCompleted(true);
                return item;
            }
        }
        throw new RuntimeException("Task not found");
    }
}

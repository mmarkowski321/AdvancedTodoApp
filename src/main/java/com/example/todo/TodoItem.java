package com.example.todo;

public class TodoItem {
    private Long id;
    private String task;
    private boolean completed;

    public TodoItem(Long id, String task) {
        this.id = id;
        this.task = task;
        this.completed = false;
    }

    // Gettery i settery
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}

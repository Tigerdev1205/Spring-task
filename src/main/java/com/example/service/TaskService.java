package com.example.task.service;

import com.example.task.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TaskService {
    private List<Task> tasks = new ArrayList<>();
    private AtomicLong counter = new AtomicLong(1);

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Optional<Task> getTaskById(Long id) {
        return tasks.stream().filter(task -> task.getId().equals(id)).findFirst();
    }

    public Task createTask(Task task) {
        task.setId(counter.getAndIncrement());
        task.setCreateDate(new Date());
        tasks.add(task);
        return task;
    }

    public Optional<Task> updateTask(Long id, Task updatedTask) {
        Optional<Task> taskOptional = getTaskById(id);
        if (taskOptional.isPresent()) {
            Task task = taskOptional.get();
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setCompleted(updatedTask.getCompleted());
            task.setCompletedDate(updatedTask.getCompletedDate());
            return Optional.of(task);
        }
        return Optional.empty();
    }
}

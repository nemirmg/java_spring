package ru.gb.hw10.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import ru.gb.hw10.model.Status;
import ru.gb.hw10.model.Task;
import ru.gb.hw10.services.TaskService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    
    private final TaskService service;

    @GetMapping
    public ResponseEntity<?> getAllTask() {
        List<Task> tasks = service.getAllTask();
        if (tasks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/{status}")
    public ResponseEntity<?> getAllTaskByStatus(@PathVariable("status") Status status) {
        List<Task> tasks = service.getTaskByStatus(status);
        if (tasks.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<?> addTask(@RequestParam String description) {
        Task task = new Task();
        task.setDescription(description);
        if (service.createTask(task)){
            return new ResponseEntity<>(task, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTaskStatus(@PathVariable("id") Long id, @RequestBody Status[] status) {
        if (service.updateTaskStatus(id, status[0])) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}

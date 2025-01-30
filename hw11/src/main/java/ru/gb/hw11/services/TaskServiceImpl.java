package ru.gb.hw11.services;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ru.gb.hw11.model.Status;
import ru.gb.hw11.model.Task;
import ru.gb.hw11.repository.TaskRepository;
import ru.gb.hw11.exception.TaskNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;

    @Override
    public boolean createTask(Task task) {
        if (task != null || task.getDescription() != null) {
            LocalDateTime date = LocalDateTime.now();
            task.setCreateAt(date);
            task.setChangesAt(date);
            task.setStatus(Status.TODO);

            repository.save(task);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteTask(Long id) {
        Optional<Task> task = repository.findById(id);
        if (task.isPresent()) {
            repository.deleteById(id);
            return true;
        }
        throw new TaskNotFoundException();
    }

    @Override
    public List<Task> getAllTask() {
        List<Task> tasks = repository.findAll();
        if (!tasks.isEmpty()) {
            return tasks;
        }
        return Collections.emptyList();
    }

    @Override
    public Task getTaskById(Long id) {
        Optional<Task> task = repository.findById(id);
        if (task.isPresent()) {
            return task.get();
        }
        throw new TaskNotFoundException();
    }

    @Override
    public List<Task> getTaskByStatus(Status status) {
        //return repository.getAllTaskByStatus(status); 
        return repository.findAll().stream().filter(s -> s.getStatus().equals(status)).toList();
    }

    @Override
    public boolean updateTaskStatus(Long id, Status status) {
        Optional<Task> optionalTask = repository.findById(id);
        if (optionalTask.isPresent()) {
            Task updatedTask = optionalTask.get();
            updatedTask.setStatus(status);
            updatedTask.setChangesAt(LocalDateTime.now());
            repository.save(updatedTask);
            return true;
        }
        throw new TaskNotFoundException();
    }

}

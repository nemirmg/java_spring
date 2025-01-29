package ru.gb.hw5.services;

import ru.gb.hw5.model.Status;
import ru.gb.hw5.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTask();

    List<Task> getTaskByStatus(Status status);

    Task getTaskById(Long id);

    boolean createTask(Task task);

    boolean updateTaskStatus(Long id, Status status);

    boolean deleteTask(Long id);
}

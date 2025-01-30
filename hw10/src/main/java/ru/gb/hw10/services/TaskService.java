package ru.gb.hw10.services;

import ru.gb.hw10.model.Task;
import ru.gb.hw10.model.Status;
import java.util.List;

public interface TaskService {

    List<Task> getAllTask();

    List<Task> getTaskByStatus(Status status);

    Task getTaskById(Long id);

    boolean createTask(Task task);

    boolean updateTaskStatus(Long id, Status status);

    boolean deleteTask(Long id);
}
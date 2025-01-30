package ru.gb.hw11.services;

import ru.gb.hw11.model.Task;
import ru.gb.hw11.model.Status;
import java.util.List;

public interface TaskService {

    List<Task> getAllTask();

    List<Task> getTaskByStatus(Status status);

    Task getTaskById(Long id);

    boolean createTask(Task task);

    boolean updateTaskStatus(Long id, Status status);

    boolean deleteTask(Long id);
}
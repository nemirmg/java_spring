package ru.gb.hw5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.gb.hw5.model.Status;
import ru.gb.hw5.model.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query(value = "SELECT * FROM tasks WHERE status = :status", nativeQuery=true)
    List<Task> getAllTaskByStatus(Status status);
}

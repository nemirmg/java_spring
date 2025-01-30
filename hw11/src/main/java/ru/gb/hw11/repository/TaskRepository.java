package ru.gb.hw11.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ru.gb.hw11.model.Status;
import ru.gb.hw11.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {    

    @Query(value = "SELECT * FROM tasks WHERE status=:status", nativeQuery=true)
    List<Task> getAllTaskByStatus(Status status);
}

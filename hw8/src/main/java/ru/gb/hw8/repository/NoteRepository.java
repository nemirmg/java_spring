package ru.gb.hw8.repository;

import ru.gb.hw8.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}

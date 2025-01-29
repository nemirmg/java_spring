package ru.gb.hw6.repository;

import ru.gb.hw6.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}

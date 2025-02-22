package ru.gb.hw8.service;

import ru.gb.hw8.aspect.TrackUserAction;
import org.springframework.stereotype.Service;

import ru.gb.hw8.entity.Note;
import ru.gb.hw8.exception.NoteNotFountException;
import ru.gb.hw8.repository.NoteRepository;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

/**
 * Сервис обработка запросов из контроллера
 */
@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NoteRepository repository;

    /**
     * Добавление заметки
     * @param note
     * @return
     */
    @Override
    public Note addNote(Note note) {
        if (note != null) {
            note.setChangesAt(LocalDateTime.now());
            return repository.save(note);
        }
        throw new NoteNotFountException();
    }

    /**
     * Удаление заметки
     * @param id
     * @return
     */
    @Override
    public boolean deleteNote(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    /**
     * Получение списка всех заметок
     * @return
     */
    @TrackUserAction
    @Override
    public List<Note> getAll() {
        List<Note> notes = repository.findAll();
        if (notes.isEmpty()) {
            return Collections.emptyList();
        }
        return notes;
    }

    /**
     * Получение заметки по ID
     * @param id
     * @return
     */
    @TrackUserAction
    @Override
    public Note getById(Long id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * Изменение данных заметки
     * @param note
     * @return
     */
    @Override
    public boolean updateNote(Note note) {
        Note updatedNote = getById(note.getId());
        if (updatedNote != null) {
            updatedNote.setTitle(note.getTitle());
            updatedNote.setDescription(note.getDescription());
            updatedNote.setChangesAt(LocalDateTime.now());
            repository.save(updatedNote);
            return true;
        }
        return false;
    }
}

package ru.gb.hw6.service;

import java.util.List;

import ru.gb.hw6.entity.Note;

public interface NoteService {

    List<Note> getAll();

    Note getById(Long id);

    Note addNote(Note note);

    boolean updateNote(Note note);

    boolean deleteNote(Long id);
}

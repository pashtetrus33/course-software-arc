package ru.geekbrains.lesson6.notes.core.application;

import ru.geekbrains.lesson6.notes.core.application.interfaces.NoteEditor;
import ru.geekbrains.lesson6.notes.core.application.interfaces.NotesDatabaseContext;
import ru.geekbrains.lesson6.notes.core.application.interfaces.NotesPresenter;
import ru.geekbrains.lesson6.notes.core.domain.Note;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

public class ConcreteNoteEditor implements NoteEditor {

    private final NotesDatabaseContext dbContext;
    private final NotesPresenter notesPresenter;

    public ConcreteNoteEditor(NotesDatabaseContext dbContext,
                              NotesPresenter notesPresenter) {
        this.dbContext = dbContext;
        this.notesPresenter = notesPresenter;
    }

    @Override
    public boolean add(Note item) {

        Collection<Note> notesList = dbContext.getAll();
        item.setId(1001 + (int) notesList.stream().count());
        notesList.add(item);
        return dbContext.saveChanges(notesList);
    }

    @Override
    public boolean edit(Note item) {
        if (item == null)
            return false;
        Optional<Note> note = getById(item.getId());
        if (note.isEmpty())
            return false;
        Collection<Note> notesList = dbContext.getAll();
        notesList.remove(note.get());
        note.get().setId(item.getId());
        note.get().setTitle(item.getTitle());
        note.get().setDetails(item.getDetails());
        note.get().setEditDate(new Date());
        notesList.add(note.get());
        return dbContext.saveChanges(notesList);
    }

    @Override
    public boolean remove(int noteId) {
        Optional<Note> item = getById(noteId);
        if (item.isEmpty()) {
            System.out.println("Заметка не найдена!");
            return false;
        }

        Collection<Note> notesList = dbContext.getAll();
        notesList.remove(item.get());
        return dbContext.saveChanges(notesList);
    }

    @Override
    public Optional<Note> getById(Integer id) {
        return dbContext.getAll().stream().filter(p -> p.getId() == id).findFirst();
    }

    @Override
    public Collection<Note> getAll() {
        return dbContext.getAll();
    }

    @Override
    public void printAll() {
        notesPresenter.printAll(getAll());
    }
}

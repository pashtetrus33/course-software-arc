package ru.geekbrains.lesson6.notes.core.application.interfaces;

import ru.geekbrains.lesson6.notes.core.domain.Note;

import java.util.Collection;
import java.util.Optional;

public interface Editor<T, TId> {

    boolean add(T item);

    boolean edit(Note item);

    boolean remove(int TId);

    Optional<T> getById(TId id);

    Collection<T> getAll();
}

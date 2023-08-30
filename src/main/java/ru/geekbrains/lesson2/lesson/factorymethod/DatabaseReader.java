package ru.geekbrains.lesson2.lesson.factorymethod;

import ru.geekbrains.lesson2.lesson.templatemethod.LogEntry;
import ru.geekbrains.lesson2.lesson.templatemethod.LogReader;

public class DatabaseReader extends LogReader {
    @Override
    public Object getDataSource() {
        return null;
    }

    @Override
    public void setDataSource(Object data) {

    }

    @Override
    protected Iterable<String> readEntries(Integer position) {
        return null;
    }

    @Override
    protected LogEntry parseLogEntry(String stringEntry) {
        return null;
    }
}

package ru.geekbrains.lesson6.database;

import java.util.Date;

public class NotesRecord {

    private static int counter = 1000;

    private int id;
    private int userId;

    private String title;

    private String details;

    private Date creationDate;
    private Date editDate;

    {
        id = ++counter;
    }

    public NotesRecord(String title, String details) {
        this.title = title;
        this.details = details;
        creationDate = new Date();
    }

    public NotesRecord(String title, String details, Date date) {
        this(title, details);
        creationDate = date;
    }

    public NotesRecord(int id, String title, String details, Date date) {
        this(title, details);
        creationDate = date;
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setEditDate(Date editDate) {
        this.editDate = editDate;
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public static void setCounter(int counter) {
        NotesRecord.counter = counter;
    }

    public String getTitle() {
        return title;
    }

    public String getDetails() {
        return details;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getEditDate() {
        return editDate;
    }


}

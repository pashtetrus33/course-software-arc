package ru.geekbrains.lesson6.notes.core.domain;

import java.util.Date;
import java.util.Objects;

public class Note {

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                '}';
    }

    //region Constructors

    public Note(int id, int userId, String title, String details, Date creationDate) {
        this(id, title, details, creationDate);
        this.userId = userId;
    }

    public Note(int id, String title, String details, Date creationDate) {
        this(title, details, creationDate);
        this.id = id;
    }

    public Note(String title, String details, Date creationDate) {
        this.title = title;
        this.details = details;
        this.creationDate = creationDate;
    }


    //endregion

    //region Public Getters And Setters (Properties)

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return id == note.id && userId == note.userId && Objects.equals(title, note.title) && Objects.equals(details, note.details) && Objects.equals(creationDate, note.creationDate) && Objects.equals(editDate, note.editDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, title, details, creationDate, editDate);
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

    public void setId(int id) {
        this.id = id;
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

    //endregion

    //region Private Fields

    private int id;
    private int userId;
    private String title;
    private String details;
    private Date creationDate;
    private Date editDate;

    //endregion

}

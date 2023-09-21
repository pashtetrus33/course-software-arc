package ru.geekbrains.lesson8.models;

import java.util.Date;

public class Reservation {


    public int getId() {
        return id;
    }

    private static int counter = 1000;
    private final int id;

    private Table table;

    private Date date;
    private String name;

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Бронирование #" + id + " {" +
                "столик: " + table.getNo() +
                ", дата: " + date +
                ", имя:"  + name + "}";
    }

        public Table getTable () {
            return table;
        }

        {
            id = ++counter;
        }

    public Reservation(Table table, Date date, String name) {
            this.table = table;
            this.date = date;
            this.name = name;
        }
    }

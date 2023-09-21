package ru.geekbrains.lesson8.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Table {

    public int getNo() {
        return no;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    private final List<Reservation> reservations = new ArrayList<>();

    private static int counter;
    private final int no;

    {
        no = ++counter;
    }

    @Override
    public String toString() {
        return String.format(Locale.getDefault(), "Столик #%d", no);
    }
}

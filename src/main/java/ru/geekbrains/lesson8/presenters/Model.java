package ru.geekbrains.lesson8.presenters;

import ru.geekbrains.lesson8.models.Reservation;
import ru.geekbrains.lesson8.models.Table;

import java.util.Date;
import java.util.List;

public interface Model {

    List<Table> loadTables();

    int reservationTable(Date reservationDate, int tableNo, String name);

    int changeReservationTable(int oldReservation, Date newOrderDate, int newTableNo, String newName);

    int deleteReservationTable(int reservationId, String name);

    List<Reservation> getAllReservations();
}

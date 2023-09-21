package ru.geekbrains.lesson8.presenters;

import ru.geekbrains.lesson8.models.Reservation;

import java.util.Date;
import java.util.List;

public interface ViewObserver {

    void onReservationTable(Date orderDate, int tableNo, String name);

    void onChangeReservationTable(int oldReservation, Date newOrderDate, int newTableNo, String newName);

    void onShowAllReserations();


    void onDeleteReservationTable(int reservationNo, String bookingName);
}

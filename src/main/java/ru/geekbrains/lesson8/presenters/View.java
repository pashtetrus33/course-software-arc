package ru.geekbrains.lesson8.presenters;

import ru.geekbrains.lesson8.models.Reservation;
import ru.geekbrains.lesson8.models.Table;

import java.util.Date;
import java.util.List;

public interface View {

    /**
     * Отображение списка столиков в приложении
     *
     * @param tables список столиков
     */
    void showTables(List<Table> tables);

    /**
     * Отобразить результат бронирования столика
     *
     * @param reservationNo номер брони
     */
    void showReservationTableResult(int reservationNo, String name);


    /**
     * Установить наблюдателя для представления
     *
     * @param observer наблюдатель
     */
    void setObserver(ViewObserver observer);

    /**
     * Событие: Клиент нажал на кнопку резерва столика
     *
     * @param orderDate дата резерва
     * @param tableNo   номер столика
     * @param name      имя клиента
     */
    void reservationTable(Date orderDate, int tableNo, String name);

    /**
     * Cобытие: Клиент нажал на кнопку изменения резерва
     *
     * @param oldReservation идентификатор бронирования (старый)
     * @param newOrderDate   новая дата резерва
     * @param newTableNo     новый номер столика
     * @param newBookingName новое имя клиента
     */
    void changeReservationTable(int oldReservation, Date newOrderDate, int newTableNo, String newBookingName);

    void showReservations(List<Reservation> reservations);

    void deleteReservationTable(int reservationNo, String bookingName);
}
